package com.example.machineCodingWithDB.Repository;

import com.example.machineCodingWithDB.models.Developer;
import org.springframework.data.repository.CrudRepository;

public interface DeveloperRepository extends CrudRepository<Developer,Integer> {

}
