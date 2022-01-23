package com.dawidonak.turneyapp.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name ="gamesystem")
public class GameSystem {

    @Id
    @Column(name ="gameSystemId")
    private Long gameSystemID;

    @Column(name ="gameSystemName")
    private String gameSystemName;
}
