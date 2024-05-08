package com.project.cafetest.repository;

import com.project.cafetest.model.aboutUs;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface aboutUsRepo extends MongoRepository<aboutUs, Integer>{
}
