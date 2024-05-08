package com.project.cafetest.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Data
@Document(collection = "newsletter")
@AllArgsConstructor
@NoArgsConstructor
public class newsLetter {
    @Id
    private String _id;
    private String title;
    private String content;
    private Date date;
    private String image;
}
