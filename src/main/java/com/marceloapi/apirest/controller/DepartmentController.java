package com.marceloapi.apirest.controller;

import com.marceloapi.apirest.entities.Department;
import com.marceloapi.apirest.entities.Product;
import com.marceloapi.apirest.repositories.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

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

    @PostMapping
    public Department addDepartment(@RequestBody Department department) {
        return this.departmentRepository.save(department);
    }
    @PutMapping("/{id}")
    public Department addDepartment(@PathVariable long id, @RequestBody Department derpartment ){

        Department existingDepartment = departmentRepository.findById(id).orElse(null);

        if(existingDepartment != null) {
            existingDepartment.setName(derpartment.getName());

            return departmentRepository.save(existingDepartment);
        }else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Product nut found");
        }

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable("id") Long id) {
        if (departmentRepository.existsById(id)) {
            departmentRepository.deleteById(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

}
