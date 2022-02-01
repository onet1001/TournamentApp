package com.dawidonak.turneyapp.security.service;

import com.dawidonak.turneyapp.domain.dto.AddGameDto;
import com.dawidonak.turneyapp.domain.dto.ChangeGamePairs;
import com.dawidonak.turneyapp.domain.dto.EditGameResultDto;
import com.dawidonak.turneyapp.domain.dto.GameDto;
import com.dawidonak.turneyapp.domain.entity.Game;
import com.dawidonak.turneyapp.domain.entity.Participant;
import com.dawidonak.turneyapp.domain.entity.Tournament;
import com.dawidonak.turneyapp.domain.mapper.GameMapper;
import com.dawidonak.turneyapp.repository.GameReopsitory;
import com.dawidonak.turneyapp.repository.ParticipantRepository;
import com.dawidonak.turneyapp.repository.TournamentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class GameService {
    private final GameReopsitory gameReopsitory;
    private final GameMapper gameMapper;
    private final TournamentRepository tournamentRepository;
    private final ParticipantRepository participantRepository;

    public GameService(GameReopsitory gameReopsitory, GameMapper gameMapper, TournamentRepository tournamentRepository, ParticipantRepository participantRepository) {
        this.gameReopsitory = gameReopsitory;
        this.gameMapper = gameMapper;
        this.tournamentRepository = tournamentRepository;
        this.participantRepository = participantRepository;
    }

    public void createMatchUp(AddGameDto addGameDto) {
        Participant p1 = participantRepository.findById(addGameDto.getParticipantOneId()).orElseThrow(() -> new RuntimeException());
        Participant p2 = participantRepository.findById(addGameDto.getParticipantTwoId()).orElseThrow(() -> new RuntimeException());
        Tournament tournament = tournamentRepository.findById(addGameDto.getTournamentId()).orElseThrow(() -> new RuntimeException());
        Game game = Game.builder()
                .tournament(tournament)
                .participantOne(p1)
                .participantTwo(p2)
                .playerOneScore(0L)
                .playerTwoScore(0L)
                .build();
        gameReopsitory.save(game);
    }


    public void editResult(EditGameResultDto editGameResultDto) {
        Participant p1 = participantRepository.findById(editGameResultDto.getParticipantOneId()).orElseThrow(() -> new RuntimeException());
        Participant p2 = participantRepository.findById(editGameResultDto.getParticipantTwoId()).orElseThrow(() -> new RuntimeException());
        Game game = gameReopsitory.findById(editGameResultDto.getGameId()).orElseThrow(() -> new RuntimeException());
        game.setPlayerOneScore(editGameResultDto.getParticipantOneScore());
        game.setPlayerTwoScore(editGameResultDto.getParticipantTwoScore());
        p1.setParticipantScore(p1.getParticipantScore() + editGameResultDto.getParticipantOneScore());
        p2.setParticipantScore(p2.getParticipantScore() + editGameResultDto.getParticipantTwoScore());
        gameReopsitory.save(game);
        participantRepository.save(p1);
        participantRepository.save(p2);
    }

    // dobranie przeciwników
    public void createFirstBracket(Long tournamentId) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow(() -> new RuntimeException());
        List<Participant> participantList = participantRepository.findAllByTournament_TournamentId(tournamentId);
        int a = participantList.size();
        int iterator = a / 2;
        for (int i = 0; i < iterator; i++) {
            AddGameDto addGameDto = AddGameDto.builder()
                    .tournamentId(tournament.getTournamentId())
                    .participantOneId(participantList.get(i).getParticipantId())
                    .participantTwoId(participantList.get(a - 1 - i).getParticipantId())
                    .build();
            createMatchUp(addGameDto);
        }
    }

    //ogarnąć pętle
    public void createBracket(Long tournamentId) {
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow(() -> new RuntimeException());
        List<Participant> participantList = participantRepository.findAllByTournament_TournamentId(tournamentId);
        int a = participantList.size();
        for (int i = 0; i < a; i = +2) {
            AddGameDto addGameDto = AddGameDto.builder()
                    .tournamentId(tournament.getTournamentId())
                    .participantOneId(participantList.get(i).getParticipantId())
                    .participantTwoId(participantList.get(i + 1).getParticipantId())
                    .build();
            createMatchUp(addGameDto);
        }
    }


    //zmiana przeciwnika
    public void changeOpponent(ChangeGamePairs changeGamePairs) {
        Game game1 = gameReopsitory.findById(changeGamePairs.getGameAId()).orElseThrow(() -> new RuntimeException());
        Game game2 = gameReopsitory.findById(changeGamePairs.getGameBId()).orElseThrow(() -> new RuntimeException());
        Participant p1 = participantRepository.findById(changeGamePairs.getPairAParticipantOneId()).orElseThrow(() -> new RuntimeException());
        Participant p2 = participantRepository.findById(changeGamePairs.getPairBParticipantOneId()).orElseThrow(() -> new RuntimeException());
        game1.setParticipantOne(p1);
        game2.setParticipantOne(p2);
        gameReopsitory.save(game1);
        gameReopsitory.save(game2);
    }

    //Wyświetlenie histori gier na turnieju
    public List<GameDto> gameHistory(Long participantId) {
        return gameReopsitory.findByParticipantId(participantId)
                .stream()
                .map(game -> gameMapper.toDto(game))
                .collect(Collectors.toList());
    }



    //poprawic
//    public List<GameDto> gameAllHistory(Long userId) {
//        return gameReopsitory.getGameListByUserID(userId)
//                .stream()
//                .map(game -> gameMapper.toDto(game))
//                .collect(Collectors.toList());
//    }
}
