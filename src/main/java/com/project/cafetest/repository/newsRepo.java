package com.project.cafetest.repository;

import com.project.cafetest.model.newsLetter;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Optional;

public interface newsRepo extends MongoRepository<newsLetter, String>{

}
