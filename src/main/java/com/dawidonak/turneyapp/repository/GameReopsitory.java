package com.dawidonak.turneyapp.repository;


import com.dawidonak.turneyapp.domain.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameReopsitory extends JpaRepository<Game, Long> {

    @Query("SELECT g FROM Game g WHERE g.participantOne.participantId = :participantId OR g.participantTwo.participantId = :participantId")
    List<Game> findByParticipantId(@Param("participantId") Long participantId);

//    @Query("SELECT g FROM Game g INNER JOIN Participant p WHERE p.user.userId = :userId")
//    List<Game> getGameListByUserID(@Param("userId") Long userId);
}
