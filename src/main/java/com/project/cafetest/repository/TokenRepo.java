package com.project.cafetest.repository;

import com.project.cafetest.model.Token;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface TokenRepo extends MongoRepository<Token, String> {


    List<Token> findAllTokenByUser(String token);

    Optional<Token> findByToken(String token);
}
