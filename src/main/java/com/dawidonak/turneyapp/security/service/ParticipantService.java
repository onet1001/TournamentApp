package com.dawidonak.turneyapp.security.service;

import com.dawidonak.turneyapp.domain.dto.AddParticipantDto;
import com.dawidonak.turneyapp.domain.dto.GameDto;
import com.dawidonak.turneyapp.domain.dto.ParticipantDto;
import com.dawidonak.turneyapp.domain.entity.Participant;
import com.dawidonak.turneyapp.domain.entity.Tournament;
import com.dawidonak.turneyapp.domain.entity.User;
import com.dawidonak.turneyapp.domain.mapper.ParticipantMapper;
import com.dawidonak.turneyapp.repository.ParticipantRepository;
import com.dawidonak.turneyapp.repository.TournamentRepository;
import com.dawidonak.turneyapp.repository.UserRepository;
import net.bytebuddy.implementation.bytecode.Throw;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ParticipantService {
    private final ParticipantRepository participantRepository;
    private final ParticipantMapper participantMapper;

    private final TournamentRepository tournamentRepository;
    private final UserRepository userRepository;

    public ParticipantService(ParticipantRepository participantRepository, ParticipantMapper participantMapper, TournamentRepository tournamentRepository, UserRepository userRepository) {
        this.participantRepository = participantRepository;
        this.participantMapper = participantMapper;
        this.tournamentRepository = tournamentRepository;
        this.userRepository = userRepository;
    }


    //Dołączenie na turnej - stworzenie uczestnika
    public void joinTournament(AddParticipantDto addParticipantDto){
        User user= userRepository.findById(addParticipantDto.getUserId()).orElseThrow(()->new RuntimeException());
        Tournament tournament= tournamentRepository.findById(addParticipantDto.getTournamentId()).orElseThrow(()->new RuntimeException());
        if(listAllPlayers(addParticipantDto.getTournamentId()).contains(addParticipantDto.getUserId())){

        }else{
            Participant participant = Participant.builder()
                    .user(user)
                    .tournament(tournament)
                    .participantScore(0L)
                    .build();
            participantRepository.save(participant);
        }
    }

    //lista graczy na turnieju
    public List<ParticipantDto> listAllPlayers(Long tournamentId){
        Tournament tournament= tournamentRepository.findById(tournamentId).orElseThrow(()->new RuntimeException());
        return tournament.getParticipants()
                .stream()
                .map(participant -> participantMapper.toDto(participant))
                .collect(Collectors.toList());
    }

    //usuniecie gracza z turnieju
    public void leaveTournament(Long participantId){
        Participant participant = participantRepository.findById(participantId).orElseThrow(()->new RuntimeException());
        participantRepository.delete(participant);
    }

    //historia wszystkich gier danego usera
    //kiedyś zrobimy widoczek
//    public List<GameDto> allGames(Long userId){
//        //List<Participant> participant = participantRepository.findAllByUserId(userId);
//
//        return
//
//    }
}
