package com.example.hellospring.service;

import com.example.hellospring.entity.Management;
import java.util.Optional;
import com.example.hellospring.management.ManagementRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class ManagementService {

    @Autowired
    private ManagementRespository managementRespository;

    public List<Management> findAll(String title, String category){
        return managementRespository.search(title, category);}

    public Optional<Management> findById(Integer id) {
        return managementRespository.findById(id);
    }

    public Management save(Management management) {
        return managementRespository.save(management);
    }

    public void deleteById(Integer id){
        managementRespository.deleteById(id);
    }
}
