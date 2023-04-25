package com.example.dynamicparaminspringdatajpa.repository;



import com.example.dynamicparaminspringdatajpa.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;


public interface ProductRepo extends JpaRepository<Product,Integer> {

 @Query(value  ="select * from product_table " ,nativeQuery = true)
     public List<Product> getProducts();


    @Query(value  ="select * from product_table where name =?1 and id =?2" ,nativeQuery = true)
    public List<Product> getProductByName( @Param("name") String name , @Param("id") Integer id);
}
