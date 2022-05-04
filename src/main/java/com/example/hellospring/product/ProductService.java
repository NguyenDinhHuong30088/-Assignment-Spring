package com.example.hellospring.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRespository productRespository;
    //Order, OrderDetail
    public List<Product> findAll() {
        return productRespository.findAll();
    }

    public Optional<Product> findById( int id) {
        return productRespository.findById(id);
    }

    public Product save(Product product) {
        return productRespository.save(product);
    }

    public void deleteById(int id) {
        productRespository.deleteById(id);
    }

}
