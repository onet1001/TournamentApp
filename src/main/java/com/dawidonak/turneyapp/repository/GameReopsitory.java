package com.dawidonak.turneyapp.repository;


import com.dawidonak.turneyapp.domain.entity.Game;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GameReopsitory extends JpaRepository<Game, Long> {
}
