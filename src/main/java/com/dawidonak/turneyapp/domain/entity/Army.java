package com.dawidonak.turneyapp.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder(toBuilder = true)
@Table(name = "army")
public class Army {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "army_id")
    private Long armyId;

    @Column(name = "army_url")
    private String armyUrl;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    // wersja 1
    @OneToOne(mappedBy = "army")
    private Participant participant;

    //wersja 2
//    @OneToOne
//    @JoinColumn(name = "participant_id")
//    private Participant participant;


}

