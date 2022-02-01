package com.dawidonak.turneyapp.security.service;

import com.dawidonak.turneyapp.domain.dto.AddTournamentDto;
import com.dawidonak.turneyapp.domain.dto.TournamentDto;
import com.dawidonak.turneyapp.domain.entity.Tournament;
import com.dawidonak.turneyapp.domain.mapper.TournamentMapper;
import com.dawidonak.turneyapp.repository.TournamentRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TournamentService {
    private final TournamentRepository tournamentRepository;


    public TournamentService(TournamentRepository tournamentRepository) {
        this.tournamentRepository = tournamentRepository;
    }


    public List<TournamentDto> listAllTournaments() {
        return tournamentRepository.findAll()
                .stream()
                .map(tournament -> TournamentMapper.toDto(tournament))
                .collect(Collectors.toList());
    }


    //ogarnąć gamesystemid
    public Tournament createTournament(AddTournamentDto addTournamentDto){
        Tournament tournament =Tournament.builder()
                .tournamentName(addTournamentDto.getTournamentName())
                .gameSystem(addTournamentDto.getGameSystem())
                .date(addTournamentDto.getDate())
                .description(addTournamentDto.getDescription())
                .build();
        return tournamentRepository.save(tournament);

    }


    public void deleteTournament(Long tournamentId){
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow(()->new RuntimeException());
        tournamentRepository.delete(tournament);

    }

    public Tournament tournamentDetails(Long tournamentId){
        Tournament tournament = tournamentRepository.findById(tournamentId).orElseThrow(()->new RuntimeException());
        return tournament;
    }

}
