package com.project.cafetest.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Data
@Builder
@AllArgsConstructor
@Document(collection = "aboutUs")
public class aboutUs {
    @Id
    private String id_aus;
    private String aboutUs;
    private String aus_content;
    private String aus_image;
}
