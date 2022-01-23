package com.dawidonak.turneyapp.security.service;

import com.dawidonak.turneyapp.domain.dto.AddTournamentDto;
import com.dawidonak.turneyapp.domain.dto.GameSystemDto;
import com.dawidonak.turneyapp.domain.dto.TournamentDto;
import com.dawidonak.turneyapp.domain.entity.Tournament;
import com.dawidonak.turneyapp.domain.mapper.TournamentMapper;
import com.dawidonak.turneyapp.repository.TournamentRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class TournamentService {
    private final TournamentRepository tournamentRepository;
    private final TournamentMapper tournamentMapper;

    public TournamentService(TournamentRepository tournamentRepository, TournamentMapper tournamentMapper) {
        this.tournamentRepository = tournamentRepository;
        this.tournamentMapper = tournamentMapper;
    }

    //pobranie listy turnejów
    public List<TournamentDto> listAllTournaments() {
        return tournamentRepository.findAll()
                .stream()
                .map(tournament -> tournamentMapper.toDto(tournament))
                .collect(Collectors.toList());
    }

    // tworzenie turnieju
    //ogarnąć gamesystemid
    public void createTournament(AddTournamentDto addTournamentDto){
        Tournament tournament =Tournament.builder()
                .gameSystem(addTournamentDto.getGameSystem())
                .date(addTournamentDto.getDate())
                .description(addTournamentDto.getDescription())
                .build();
        tournamentRepository.save(tournament);
    }

    //usunięcie turnieju
    public void deleteTournament(Long tournamentId){

    }


}
