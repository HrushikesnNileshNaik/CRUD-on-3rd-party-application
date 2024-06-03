package com.SecondJuneDemoProject.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jmx.export.annotation.ManagedOperationParameter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.SecondJuneDemoProject.demo.DTO.FakestoreDTO;
import com.SecondJuneDemoProject.demo.model.Product;
import com.SecondJuneDemoProject.demo.service.ProductService;

@RestController

public class ProductController {

    @Autowired
    private ProductService ProductService;

    ProductController(ProductService ProductService){
        this.ProductService = ProductService;
    }



    @PostMapping("/product") 
    public Product createProduct(@RequestBody Product product){
        Product GG = ProductService.createProduct(product);
        System.out.println("Product created");
        return GG;

    }

    @GetMapping("/product/{id}")
    
    public Product getSingleProduct(@PathVariable(value = "id") Long id){
      Product product = ProductService.getSingleProduct(id);
        
        return product;
    }

    @PutMapping("/product/{id}")
    public void updateProduct(@PathVariable(value = "id") Long id, @RequestBody Product product){
        ProductService.updateProduct(id, product);
        System.out.println("Product updated");
    }



    @GetMapping("/products")
    public List<Product> GetAllProducts(){
        return ProductService.getAllProducts();
    }

    @GetMapping("/product/delete/{id}")

    public void deleteProduct(@PathVariable(value = "id") Long id){
        ProductService.deleteProduct(id);
    }

    @GetMapping("/productCatergory/{category}")
    public List<Product> getProductByCategory(@PathVariable(value = "category") String category){
        return ProductService.getProductByCategory(category);
    }
}
