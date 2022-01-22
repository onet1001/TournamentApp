package com.dawidonak.turneyapp.domain.entity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;


@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "game")
public class Game {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "game_id")
    private Long gameId;

    @ManyToOne
    @JoinColumn(name = "tournament_id")
    private Tournament tournament;

    @Column(name = "p_1_score")
    private Long playerOneScore;

    @Column(name = "p_2_score")
    private Long playerTwoScore;

    @ManyToOne
    @JoinColumn(name = "participant_one_id", referencedColumnName = "participant_id")
    private Participant participantOne;

    @ManyToOne
    @JoinColumn(name = "participant_two_id", referencedColumnName = "participant_id")
    private Participant participantTwo;
}
