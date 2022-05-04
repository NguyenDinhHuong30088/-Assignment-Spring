package com.example.hellospring.product;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.awt.print.Pageable;
import java.util.List;

@Repository
public interface ProductRespository extends JpaRepository<Product,Integer> {
        Page<Product> findAll(Pageable pageable);

        @Query(value= "SELECT * FROM products p WHERE p.name like %:name% and p.description like %:description%",
                nativeQuery = true)
        List<Product> findAllByNameContainsAAndPAndPriceLessThanEqual(String name, double price);
        @Query(value = "select * from product s WHERE s.name like %:name% and s.price <= :price", nativeQuery = true)
        List<Product> search(@Param("name")String name,@Param("description") String description);
}
