package com.marceloapi.apirest.controller;

import com.marceloapi.apirest.entities.Department;
import com.marceloapi.apirest.entities.Product;
import com.marceloapi.apirest.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping(value = "/departments")
public class DepartmentController {

    @Autowired
    private DepartmentRepository departmentRepository;
    @GetMapping
    public List<Department> getObjects(){


        List<Department> list = departmentRepository.findAll();

        return list;
    }
}
