package com.example.hellospring.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping(path = "/api/v1/products")
public class ProductApi {

    @Autowired
    ProductService productService;

    @RequestMapping(method = RequestMethod.GET)
    public Page<Product> getList(@RequestParam(defaultValue = "1") int page, @RequestParam(defaultValue = "10") int limit){
        return productService.findAll(page,limit);
    }

    @RequestMapping(method = RequestMethod.GET, path = "/{id}")
    public Product findById(@PathVariable int id){
        return productService.findById(id).get();
    }

    @RequestMapping (method = RequestMethod.POST)
    public Product save(@RequestBody Product product){
        productService.save(product);
        return product;
    }

    @RequestMapping(method = RequestMethod.PUT, path = "/{id}")
    public  Product update(@PathVariable int id, @RequestBody Product updateProduct) {
        Product existing = productService.findById(id).get();
        existing.setName(updateProduct.getName());
        productService.save(existing);
        return updateProduct;
    }

    @RequestMapping(method = RequestMethod.DELETE, path = "/{id}")
    public boolean delete(@PathVariable int id){
        productService.deleteById(id);
        return true;
    }
}