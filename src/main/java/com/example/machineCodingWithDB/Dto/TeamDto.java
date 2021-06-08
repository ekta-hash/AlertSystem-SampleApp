package com.example.machineCodingWithDB.Dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
public class TeamDto {
    private String name;
    private List<DeveloperDto> developerDtos;

}
