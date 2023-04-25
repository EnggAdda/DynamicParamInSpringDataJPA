package com.example.dynamicparaminspringdatajpa.controller;

import com.example.dynamicparaminspringdatajpa.entity.Product;
import com.example.dynamicparaminspringdatajpa.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {
    @Autowired
    private ProductService productService;
    @GetMapping("/all")
    public List<Product> getAllProductsController() {
        return  productService.getAllProducts();
    }


    @PostMapping("/insert")
    public Product insertProductInDb(@RequestBody Product product) {
        return  productService.insertProductIntoDatabase(product);
    }

    @GetMapping("/find/{id}")
    public Product getProductById(@PathVariable int id) {
        return  productService.getProductById(id);
    }

    @PutMapping("/update/{id}")
    public Product updateProductById(@PathVariable int id,@RequestBody Product product) {
       return productService.updateProduct(id,product);
    }

    @DeleteMapping("/delete/{id}")
    public Product deleteProductById(@PathVariable int id) {
       return productService.deleteProduct(id);
    }

    @GetMapping("/nativeQuery/{name}/{id}")
    public List<Product> getAll(@PathVariable String name , @PathVariable Integer id ) {
        return productService.getAllProductsThroughNativeQuery(name, id );

    }


}
