package edu.depaul.cdm.se.SpaceApplication;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface PlanetRepository extends MongoRepository<Planets, Long> {

    public Planets findByName(String planetName);

}
