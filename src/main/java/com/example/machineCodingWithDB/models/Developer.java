package com.example.machineCodingWithDB.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@Entity
public class Developer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String devName;
    private String phoneNumber;
    @ManyToOne
    @JoinColumn(name="team_id")
    private Team team;



}
