package com.project.cafetest.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.project.cafetest.model.newsLetter;
import com.project.cafetest.service.newsLetterService;
import java.util.List;


@RestController
@RequestMapping("/api/newsletter")
public class newsController {

    @Autowired
    private newsLetterService newsLetterService;

    @GetMapping("/get")
    public List<newsLetter> getAllNewsLetters() {
        return newsLetterService.getAllNewsLetters();
    }

    @GetMapping("/get/{id}")
    public newsLetter getNewsLetterById(@PathVariable String id) {
        return newsLetterService.getNewsLetterById(id);
    }

    @PostMapping("/modify")
    public newsLetter addNewsLetter(@RequestBody newsLetter newsLetter) {
        return newsLetterService.addNewsLetter(newsLetter);
    }

    @PutMapping("/modify/{id}")
    public newsLetter updateNewsLetter(@PathVariable String id, @RequestBody newsLetter newsLetter) {
        return newsLetterService.updateNewsLetter(id, newsLetter);
    }

    @DeleteMapping("/modify/{id}")
    public void deleteNewsLetter(@PathVariable String id) {
        newsLetterService.deleteNewsLetter(id);
    }
}
