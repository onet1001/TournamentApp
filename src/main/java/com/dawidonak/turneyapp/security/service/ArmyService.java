package com.dawidonak.turneyapp.security.service;

import com.dawidonak.turneyapp.domain.dto.AddArmyDto;
import com.dawidonak.turneyapp.domain.dto.EditArmyDto;
import com.dawidonak.turneyapp.domain.entity.Army;
import com.dawidonak.turneyapp.domain.entity.Participant;
import com.dawidonak.turneyapp.domain.entity.Tournament;
import com.dawidonak.turneyapp.repository.ArmyRepository;
import com.dawidonak.turneyapp.repository.ParticipantRepository;
import com.dawidonak.turneyapp.repository.TournamentRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;


@Service
public class ArmyService {
    private final ArmyRepository armyRepository;
    private final ParticipantRepository participantRepository;
    private final TournamentRepository tournamentRepository;
    public ArmyService(ArmyRepository armyRepository, ParticipantRepository participantRepository, TournamentRepository tournamentRepository) {
        this.armyRepository = armyRepository;
        this.participantRepository = participantRepository;
        this.tournamentRepository = tournamentRepository;
    }




    @Transactional
    public void addArmy(AddArmyDto addArmyDto){
        //dodać wyjątek
        Participant participant = participantRepository.findById(addArmyDto.getParticipantId()).orElseThrow(()->new RuntimeException());
        Tournament tournament = tournamentRepository.findById(addArmyDto.getTournamentId()).orElseThrow(()->new RuntimeException());
        Army army = Army.builder()
                .tournament(tournament)
                .participant(participant)
                .armyUrl(addArmyDto.getArmyUrl())
                .build();
        armyRepository.save(army);
        participant.setArmy(army);
    }

    public void editArmy(EditArmyDto editArmyDto){
        Army army = armyRepository.findById(editArmyDto.getArmyId()).orElseThrow(()->new RuntimeException());
        army.setArmyUrl(editArmyDto.getArmyUrl());
        armyRepository.save(army);
    }


    public String getArmy(Long armyId){
        Army army = armyRepository.findById(armyId).orElseThrow(()->new RuntimeException());
        return army.getArmyUrl();
    }
}
