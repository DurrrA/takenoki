package com.project.cafetest.service;

import com.project.cafetest.model.newsLetter;
import com.project.cafetest.repository.newsRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class newsLetterService {

    @Autowired
    private newsRepo newsRepo;

    public List<newsLetter> getAllNewsLetters() {
        return newsRepo.findAll();
    }

    public newsLetter getNewsLetterById(String id) {
        return newsRepo.findById(id).orElse(null);
    }

    public newsLetter addNewsLetter(newsLetter newsLetter) {
        return newsRepo.save(newsLetter);
    }

    public newsLetter updateNewsLetter(String id, newsLetter newsLetter) {
        newsLetter.set_id(id);
        return newsRepo.save(newsLetter);
    }

    public void deleteNewsLetter(String id) {
        newsRepo.deleteById(id);
    }
}