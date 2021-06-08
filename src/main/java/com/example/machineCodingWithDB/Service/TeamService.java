package com.example.machineCodingWithDB.Service;


import com.example.machineCodingWithDB.Dto.TeamDto;

import java.net.URISyntaxException;

public interface TeamService {
    public void createTeam(TeamDto team);
    public void sendAlert(String teamName) throws URISyntaxException;
}
