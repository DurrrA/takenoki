package com.project.cafetest.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "menu")
public class MenuItem {
    @Id
    @Generated
    private String uuid;
    private String nama;
    private String category;
    private String short_desc;
    private double harga;
    private String gambar;

}