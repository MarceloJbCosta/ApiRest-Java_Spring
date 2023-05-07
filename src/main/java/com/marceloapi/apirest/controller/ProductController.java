package com.marceloapi.apirest.controller;

import com.marceloapi.apirest.entities.Department;
import com.marceloapi.apirest.entities.Product;
import jakarta.servlet.http.PushBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/products")     //caminho endpoint
public class ProductController {
    @GetMapping
    public List<Product> getObjects(){

        Department d1 = new Department(1l, "Tech");
        Department d2 = new Department(2l, "Pet");

        Product p1 = new Product(1l, "MackBook Pro", 4000.00, d1);
        Product p2 = new Product(2l, "PC Gamer", 6000.00, d1);
        Product p3 = new Product(3l, "Pet House ", 300.00, d2);

        List<Product> list = Arrays.asList(p1, p2, p3);

        return list;
    }

}
