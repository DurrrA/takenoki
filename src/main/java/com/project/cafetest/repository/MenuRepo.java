package com.project.cafetest.repository;

import com.project.cafetest.model.MenuItem;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MenuRepo extends MongoRepository<MenuItem, String> {
}
