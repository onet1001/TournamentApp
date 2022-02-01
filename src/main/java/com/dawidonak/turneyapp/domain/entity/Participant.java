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
@Builder
@Table(name = "participant")
public class Participant {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "participant_id")
    private Long participantId;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    @ManyToOne
    @JoinColumn(name="tournament_id")
    private Tournament tournament;

    //wersja 2
//    @OneToOne(mappedBy = "participant")
//    private Army army;

    //Wersja 1
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "army_id")
    private Army army;

    @Column(name = "participant_score")
    private Long participantScore;
}
