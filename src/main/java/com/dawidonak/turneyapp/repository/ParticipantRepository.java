package com.dawidonak.turneyapp.repository;

import com.dawidonak.turneyapp.domain.entity.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ParticipantRepository  extends JpaRepository<Participant, Long> {
}
