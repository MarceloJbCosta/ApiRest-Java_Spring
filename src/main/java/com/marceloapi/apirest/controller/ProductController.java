package com.marceloapi.apirest.controller;

import com.marceloapi.apirest.entities.Department;
import com.marceloapi.apirest.entities.Product;
import com.marceloapi.apirest.repositories.DepartmentRepository;
import com.marceloapi.apirest.repositories.ProductRepository;
import jakarta.servlet.http.PushBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/products")     //caminho endpoint
public class ProductController {
    @Autowired
    private ProductRepository productRepository;
    private DepartmentRepository departmentRepository;

    @GetMapping
    public List<Product> getObjects(){


        List<Product> list = productRepository.findAll();

        return list;
    }

    @PostMapping
    public Product addProduct(@RequestBody Product product) {
        return this.productRepository.save(product);
    }


    @PutMapping("/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody Product product) {
        Product existingProduct = productRepository.findById(id).orElse(null);

        if (existingProduct != null) {
            existingProduct.setNome(product.getNome());
            existingProduct.setPrice(product.getPrice());
            Department department = departmentRepository.findById(product.getDepartment().getId()).orElse(null);
            existingProduct.setDepartment(department);

            return productRepository.save(existingProduct);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product not found");
        }
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable("id") Long id) {
        if (productRepository.existsById(id)) {
            productRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }


    }
