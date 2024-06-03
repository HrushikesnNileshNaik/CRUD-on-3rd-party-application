package com.SecondJuneDemoProject.demo.DTO;

import com.SecondJuneDemoProject.demo.model.Category;
import com.SecondJuneDemoProject.demo.model.Product;

import java.util.*;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter

public class FakestoreDTO {
    private Long ID;
    private String title;
    private double price;
    private String category;
    private String description;
    private String image;

    public Product toProduct(){
        Product product = new Product();
        product.setId(ID);
        product.setTitle(title);
        product.setPrice(price);
        Category C = new Category();
     //   C.setId((long) 1.0);
        C.setTitle(category);
        product.setCategory(C);
        product.setDescription(description);
     //   product.setImage(image);
        return product;
    }

    public static List<Product> toProductList(FakestoreDTO[] fakestoreDTO){
        List<Product> products = new ArrayList<>();
        for(int i = 0; i < fakestoreDTO.length; i++){
            Product Q  = fakestoreDTO[i].toProduct();
            products.add(Q);
        }
        return products;
    }

}
