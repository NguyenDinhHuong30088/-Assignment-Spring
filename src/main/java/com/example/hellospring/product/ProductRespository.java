package com.example.hellospring.product;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRespository extends JpaRepository<Product,Integer> {
    @Query(value = "SELECT * FROM articles a WHERE a.title LIKE %:title% and a.category LIKE %:category%",
            nativeQuery = true)
    List<Product> search(
            @Param("name") String name, @Param("description") String description);

    List<Product> findAllByNameContainsAndPriceLessThanEqual(String name, double price);

    @Query(value = "select * from product s where s.name like %:name% and s.price <=", nativeQuery = true)

    List<Product> search(@Param("name")String name,@Param("price")String price)
}
