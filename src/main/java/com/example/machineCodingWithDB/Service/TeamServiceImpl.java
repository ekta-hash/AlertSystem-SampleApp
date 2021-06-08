package com.example.machineCodingWithDB.Service;

import com.example.machineCodingWithDB.Dto.DeveloperDto;
import com.example.machineCodingWithDB.Dto.Message;
import com.example.machineCodingWithDB.Dto.TeamDto;
import com.example.machineCodingWithDB.Repository.DeveloperRepository;
import com.example.machineCodingWithDB.Repository.TeamRepository;
import com.example.machineCodingWithDB.models.Developer;
import com.example.machineCodingWithDB.models.Team;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

@Service
public class TeamServiceImpl implements TeamService {

    private TeamRepository teamRepository;
    @Autowired
    private DeveloperRepository developerRepository;

    @Autowired
    public TeamServiceImpl(TeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public void createTeam(TeamDto teamDto) {
        Team team = new Team();
        team.setTeamName(teamDto.getName());
        List<DeveloperDto> developerDtos = teamDto.getDeveloperDtos();
        List<Developer> developerList = new ArrayList<>();
        for(DeveloperDto developerDto : developerDtos){
            Developer developer = new Developer();
            developer.setDevName(developerDto.getName());
            developer.setPhoneNumber(developerDto.getPhoneNumber());
            developerList.add(developer);
        }
        developerRepository.saveAll(developerList);
        team.setDeveloperList(developerList);
        teamRepository.save(team);
    }

    @Override
    public void sendAlert(String teamName) throws URISyntaxException {
        Team team = teamRepository.findByTeamName(teamName);
        List<Developer> developerList = team.getDeveloperList();
        Developer d = developerList.get(0);
        RestTemplate restTemplate = new RestTemplate();
        String baseUrl = "https://run.mocky.io/v3/fd99c100-f88a-4d70-aaf7-393dbbd5d99f";
        URI uri = new URI(baseUrl);
        Message message = new Message();
        message.setMessage("Too many 5xx!.. please check");
        message.setPhoneNumber(d.getPhoneNumber());
        ResponseEntity<String> result = restTemplate.postForEntity(uri, message, String.class);
        System.out.println("alert has been sent..");
    }
}
