package com.dawidonak.turneyapp.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tournament")
public class Tournament {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "tournament_id")
    private Long tournamentId;

    @Column(name = "gamesystem")
    private String gamesystem;

    @Column(name = "date")
    private Date date;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "tournament", cascade = CascadeType.PERSIST)
    private List<Army> armies;

    @OneToOne(mappedBy="tournament")
    private Participant participant;
}
