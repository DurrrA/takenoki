package com.project.cafetest.repository;

import com.project.cafetest.model.feedback;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.Date;
import java.util.List;

public interface feedbackRepo extends MongoRepository<feedback, String> {
    List<feedback> findByEmailAndDateGreaterThan(String email, Date date);
    List<feedback> findByReadStatus(boolean readStatus);
}