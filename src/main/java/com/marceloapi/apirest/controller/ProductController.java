package com.marceloapi.apirest.controller;

import com.marceloapi.apirest.entities.Department;
import com.marceloapi.apirest.entities.Product;
import com.marceloapi.apirest.repositories.ProductRepository;
import jakarta.servlet.http.PushBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/products")     //caminho endpoint
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public List<Product> getObjects(){


        List<Product> list = productRepository.findAll();

        return list;
    }

}
