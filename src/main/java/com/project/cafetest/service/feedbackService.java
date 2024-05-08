package com.project.cafetest.service;

import com.project.cafetest.model.feedback;
import com.project.cafetest.repository.feedbackRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class feedbackService {

    @Autowired
    private feedbackRepo feedbackRepo;

    public feedback saveFeedback(String email, String message) {
        Date oneHourAgo = new Date(System.currentTimeMillis() - 3600000); // One hour ago
        List<feedback> recentFeedback = feedbackRepo.findByEmailAndDateGreaterThan(email, oneHourAgo);
        if (!recentFeedback.isEmpty()) {
            throw new IllegalArgumentException("You can only submit feedback once per hour.");
        }

        feedback feedback = new feedback();
        feedback.setEmail(email);
        feedback.setMessage(message);
        feedback.setDate(new Date());
        return feedbackRepo.save(feedback);
    }

    public List<feedback> getUnreadFeedback() {
        return feedbackRepo.findByReadStatus(false);
    }

    public void markAsRead(String feedbackId) {
        feedback feedback = feedbackRepo.findById(feedbackId)
                .orElseThrow(() -> new IllegalArgumentException("Feedback not found with id: " + feedbackId));
        feedback.setReadStatus(true);
        feedbackRepo.save(feedback);
    }
}