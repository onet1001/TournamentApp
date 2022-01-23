package com.dawidonak.turneyapp.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

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

    @OneToOne
    @JoinColumn(name="tournament_id")
    private Tournament tournament;

    @OneToOne
    @JoinColumn(name = "army_id")
    private Army army;

}
