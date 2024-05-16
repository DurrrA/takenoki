package com.project.cafetest.controller;

import com.project.cafetest.model.feedback;
import com.project.cafetest.service.feedbackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/feedback")
@CrossOrigin
public class feedbackController {

    @Autowired
    private feedbackService feedbackService;

    @PostMapping("/posting")
    public feedback saveFeedback(@RequestBody feedback feedback) {
        return feedbackService.saveFeedback(feedback.getEmail(), feedback.getMessage());
    }

    @GetMapping("/unread")
    public List<feedback> getUnreadFeedback() {
        return feedbackService.getUnreadFeedback();
    }

    @GetMapping("/read")
    public List<feedback> getReadFeedback() {
        return feedbackService.getReadFeedback();
    }

    @PutMapping("/unread/{id}/read")
    public void markAsRead(@PathVariable String id) {
        feedbackService.markAsRead(id);
    }
}