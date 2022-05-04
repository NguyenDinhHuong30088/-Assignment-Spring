package com.example.hellospring.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRespository productRespository;
    public Page<Product> findAll(int page, int limit){
        return productRespository.findAll(
                PageRequest.of(page, limit, Sort.by(Sort.Direction.DESC, "price")));
    }
    public List<Product> getAll() {
        return productRespository.findAll();
    }
    public List<Product> findByNamePrice(String name, double price){
        return productRespository.findAllByNameContainsAAndPAndPriceLessThanEqual(name, price);
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
