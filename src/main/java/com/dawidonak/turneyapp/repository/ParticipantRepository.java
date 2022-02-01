package com.dawidonak.turneyapp.repository;

import com.dawidonak.turneyapp.domain.entity.Participant;
import com.dawidonak.turneyapp.domain.entity.Tournament;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ParticipantRepository  extends JpaRepository<Participant, Long> {


   // List<Participant> findAllByUserId(Long userId);
    List<Participant> findAllByTournament_TournamentId(Long tournamentId);
}
