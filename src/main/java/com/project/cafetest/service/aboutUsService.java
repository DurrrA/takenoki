package com.project.cafetest.service;


import com.project.cafetest.model.aboutUs;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.project.cafetest.repository.aboutUsRepo;
@Service
public class aboutUsService {

    @Autowired
    private aboutUsRepo aboutUsRepo;

    public aboutUs getAboutUs() {
        return aboutUsRepo.findAll().stream().findFirst().orElse(null);
    }

    public aboutUs createAboutUs(aboutUs aboutUs) {
        return aboutUsRepo.save(aboutUs);
    }

    public aboutUs updateAboutUs(String id_aus, aboutUs aboutUs) {
        aboutUs.setId_aus(id_aus);
        return aboutUsRepo.save(aboutUs);
    }
}


