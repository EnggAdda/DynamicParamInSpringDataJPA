package com.example.dynamicparaminspringdatajpa.service.impl;

import com.example.dynamicparaminspringdatajpa.entity.Product;
import com.example.dynamicparaminspringdatajpa.repository.ProductRepo;
import com.example.dynamicparaminspringdatajpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepo productRepo;

    @Override
    public List<Product> getAllProducts() {
        return productRepo.findAll();
    }

    @Override
    public Product insertProductIntoDatabase(Product product) {
        return productRepo.save(product);
    }

    @Override
    public Product getProductById(int id) {
        return productRepo.findById(id).get();
    }

    @Override
    public Product updateProduct(int id, Product product) {
        Product productFromDB = productRepo.findById(id).get();
        productFromDB.setName(product.getName());
        productFromDB.setPrice(product.getPrice());
        productFromDB.setQuantity(product.getQuantity());
        productRepo.save(productFromDB);
        return productFromDB;
    }

    @Override
    public Product deleteProduct(int id) {
        Product product = productRepo.findById(id).get();
        productRepo.deleteById(id);
        return product;
    }
 @Override
   public List<Product> getAllProductsThroughNativeQuery(String name, Integer id  ){
       return productRepo.getProductByName(name, id );
   }



}
