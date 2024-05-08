package com.project.cafetest.model;


import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Setter
@Getter
@NoArgsConstructor
@Builder
@AllArgsConstructor
@Document(collection = "feedback")
public class feedback {
    @Id
    private String id;
    private String email;
    private String message;
    private Date date;
    private boolean readStatus = false;

    public feedback(String email, String message, Date date) {
        this.email = email;
        this.message = message;
        this.date = date;
    }

}
