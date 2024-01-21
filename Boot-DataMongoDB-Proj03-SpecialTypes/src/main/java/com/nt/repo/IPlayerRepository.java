package com.nt.repo;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.nt.document.PlayerInfo;

public interface IPlayerRepository extends MongoRepository<PlayerInfo, Integer> {

}
