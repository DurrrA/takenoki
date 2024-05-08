package com.project.cafetest.controller;

import com.project.cafetest.model.aboutUs;
import com.project.cafetest.service.aboutUsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/aboutus")
public class aboutUsController {

    @Autowired
    private aboutUsService aboutUsService;

    @GetMapping
    public aboutUs getAboutUs() {
        return aboutUsService.getAboutUs();
    }

    @PutMapping("/modify/{id}")
    public aboutUs updateAboutUs(@PathVariable String id, @RequestBody aboutUs aboutUs) {
        return aboutUsService.updateAboutUs(id, aboutUs);
    }
}