package com.example.dynamicparaminspringdatajpa.service;



import com.example.dynamicparaminspringdatajpa.entity.Product;

import java.util.List;


public interface ProductService {

    List<Product> getAllProducts();

    Product insertProductIntoDatabase(Product product);

    Product getProductById(int id );

    Product updateProduct(int id, Product product);

    Product deleteProduct(int id);


    List<Product> getAllProductsThroughNativeQuery( String name, Integer id  );

}
