package com.example.machineCodingWithDB.Repository;

import com.example.machineCodingWithDB.models.Developer;
import com.example.machineCodingWithDB.models.Team;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TeamRepository extends CrudRepository<Team,Integer> {


    @Query(value = "SELECT * FROM Team t WHERE t.name = :name",
            nativeQuery = true)
    Team findByTeamName(@Param("name") String name);

}
