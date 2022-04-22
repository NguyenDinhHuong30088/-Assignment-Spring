package com.example.hellospring.management;

import com.example.hellospring.entity.Management;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ManagementRespository extends JpaRepository<Management,Integer> {
    @Query(value = "SELECT * FROM articles a WHERE a.title LIKE %:title% and a.category LIKE %:category%",
            nativeQuery = true)
    List<Management> search(
            @Param("title") String title, @Param("category") String category);
}
