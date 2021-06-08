package com.example.machineCodingWithDB.models;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Setter
@Getter
@Entity
@ToString
public class Team {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String teamName;
    @OneToMany(mappedBy = "team")
    private List<Developer> developerList;

}
