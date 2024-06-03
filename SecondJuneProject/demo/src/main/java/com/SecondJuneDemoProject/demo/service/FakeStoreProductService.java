package com.SecondJuneDemoProject.demo.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.SecondJuneDemoProject.demo.DTO.FakestoreDTO;
import com.SecondJuneDemoProject.demo.model.Product;

@Service

public class FakeStoreProductService implements ProductService{

    private RestTemplate restTemplate;

    public FakeStoreProductService(RestTemplate restTemplate){
        this.restTemplate = restTemplate;
    }


    @Override
    public Product getSingleProduct(Long id) {
        System.out.println("\n\n\n\nhttps://fakestoreapi.com/products/" + id + "\n\n\n\n");
        FakestoreDTO fakestoreDTO = restTemplate.getForObject("https://fakestoreapi.com/products/" + id, FakestoreDTO.class);
        
        return fakestoreDTO.toProduct();
    }

    @Override
    public List<Product> getAllProducts() {
        FakestoreDTO[] fakestoreDTO = restTemplate.getForObject("https://fakestoreapi.com/products", FakestoreDTO[].class);
        if(fakestoreDTO != null){
            return FakestoreDTO.toProductList(fakestoreDTO);
        }
        return null;
    }

    @Override
    public List<Product> getProductByCategory(String category) {
        FakestoreDTO[] fakestoreDTO = restTemplate.getForObject("https://fakestoreapi.com/products/category/" + category, FakestoreDTO[].class);
        if(fakestoreDTO != null){
            return FakestoreDTO.toProductList(fakestoreDTO);
        }
        return null;
    }
    

    @Override
    public void deleteProduct(Long id) {
        restTemplate.delete("https://fakestoreapi.com/products/" + id);
        System.out.println("Product "  + id +"deleted");
    }


    @Override
    public Product createProduct(Product product) {
        FakestoreDTO fakestoreDTO = new FakestoreDTO();
        fakestoreDTO.setID(product.getId());
        fakestoreDTO.setTitle(product.getTitle());
        fakestoreDTO.setPrice(product.getPrice());
        fakestoreDTO.setCategory(product.getCategory().getTitle());
        fakestoreDTO.setDescription(product.getDescription());
        fakestoreDTO.setImage(product.getURL());

        FakestoreDTO response = restTemplate.postForObject("https://fakestoreapi.com/products", fakestoreDTO, FakestoreDTO.class);

        return fakestoreDTO.toProduct();
    }

    public void updateProduct(Long id,Product product){
        FakestoreDTO fakestoreDTO = new FakestoreDTO();
        fakestoreDTO.setID(product.getId());
        fakestoreDTO.setTitle(product.getTitle());
        fakestoreDTO.setPrice(product.getPrice());
        fakestoreDTO.setCategory(product.getCategory().getTitle());
        fakestoreDTO.setDescription(product.getDescription());
        fakestoreDTO.setImage(product.getURL());
        
        restTemplate.put("https://fakestoreapi.com/products/" + id, fakestoreDTO);

    }



}
