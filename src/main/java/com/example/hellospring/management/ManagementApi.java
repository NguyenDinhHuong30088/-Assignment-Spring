package com.example.hellospring.management;

import com.example.hellospring.entity.Management;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/managements")
public class ManagementApi {

    @Autowired
    ManagementRespository managementRespository;

    @RequestMapping(method = RequestMethod.GET)
    public List<Management> getList(@RequestParam(defaultValue = "") String title,
                                 @RequestParam(defaultValue = "")String category){
        if(title.length() > 0 || category.length() > 0){
            return managementRespository.search(title, category);
        }else{
            return managementRespository.findAll();
        }
    }


    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Management getDetail(@PathVariable int id){
        return managementRespository.findById(id).get();
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Management> create(@RequestBody Management management) {
        return ResponseEntity.ok(managementRespository.save(management));
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public Management update(@PathVariable int id, @RequestBody Management updateManagement) {
        Management existing = managementRespository.findById(id).get();
        existing.setTitle(updateManagement.getTitle());
        existing.setDescription(updateManagement.getDescription());
        existing.setStatus(updateManagement.getStatus());
        existing.setThumbnail(updateManagement.getThumbnail());
        existing.setCategory(updateManagement.getCategory());
        existing.setContent(updateManagement.getContent());
        managementRespository.save(existing);
        return updateManagement;
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public boolean delete(@PathVariable int id) {
        return true;
    }
}
