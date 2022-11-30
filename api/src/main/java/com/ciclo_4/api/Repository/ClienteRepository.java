package com.ciclo_4.api.Repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.ciclo_4.api.Models.ClienteModels;

@Repository
public interface ClienteRepository extends MongoRepository<ClienteModels, String> {

}
