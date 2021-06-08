package com.example.machineCodingWithDB.Controller;

import com.example.machineCodingWithDB.Dto.TeamDto;
import com.example.machineCodingWithDB.Service.TeamService;
import com.example.machineCodingWithDB.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@RestController
@RequestMapping
public class TeamController {

    private TeamService teamService;

    @Autowired
    public TeamController(TeamService teamService) {
        this.teamService = teamService;
    }

    @PostMapping(path = "/add/team")
    public @ResponseBody String createTeam(@RequestBody TeamDto team){
        System.out.println("post request for new team" + team.toString());
        teamService.createTeam(team);
        return "Team has been added.";
    }

    @GetMapping(path = "/send/alert")
    public @ResponseBody String sendAlert(@RequestParam String teamName) throws URISyntaxException {
        teamService.sendAlert(teamName);
        return "Alert sent";
    }



}
