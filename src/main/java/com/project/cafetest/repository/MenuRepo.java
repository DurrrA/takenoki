package com.project.cafetest.repository;

import com.project.cafetest.model.MenuItem;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;

public interface MenuRepo extends MongoRepository<MenuItem, String> {

    List<MenuItem> findByNama(String nama);

    List<MenuItem> findByCategory(String category);
    List<MenuItem> findByNamaAndCategory(String nama);

    void deleteByNama(String nama);
}