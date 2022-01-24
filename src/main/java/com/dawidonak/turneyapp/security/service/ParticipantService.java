package com.dawidonak.turneyapp.security.service;

import com.dawidonak.turneyapp.domain.dto.ParticipantDto;
import com.dawidonak.turneyapp.domain.entity.Participant;
import com.dawidonak.turneyapp.domain.mapper.ParticipantMapper;
import com.dawidonak.turneyapp.repository.ParticipantRepository;

import java.util.List;
import java.util.stream.Collectors;

public class ParticipantService {
    private final ParticipantRepository participantRepository;
    private final ParticipantMapper participantMapper;
    private final ParticipantDto participantDto;

    public ParticipantService(ParticipantRepository participantRepository, ParticipantMapper participantMapper, ParticipantDto participantDto) {
        this.participantRepository = participantRepository;
        this.participantMapper = participantMapper;
        this.participantDto = participantDto;
    }


    //Dołączenie na turnej - stworzenie uczestnika
    public void joinTournament(Long userId, Long tournamentId){
        Participant participant = Participant.builder()

                .build();
        participantRepository.save(participant);

    }

    //lista graczy na turnieju
    public List<ParticipantDto> listAllPlayers(Long tournamentId){
        return participantRepository.findById(tournamentId)
                .stream()
                .map(participant -> participantMapper.toDto(participant))
                .collect(Collectors.toList());
    }

    //dodanie armii
}
