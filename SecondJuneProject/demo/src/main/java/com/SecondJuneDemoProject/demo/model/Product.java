package com.SecondJuneDemoProject.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter

@AllArgsConstructor
@NoArgsConstructor

public class Product {
    private Long id;
    private String title;
    private String description;
    private double price;
    private String URL;
    private Category category;   



    // public String getTitle() {
    //     return title;
    // }
    // public void setTitle(String title) {
    //     this.title = title;
    // }

}
