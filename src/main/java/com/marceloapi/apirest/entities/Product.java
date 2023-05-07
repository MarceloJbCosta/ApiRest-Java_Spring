package com.marceloapi.apirest.entities;

public class Product {

    private long id;
    private String nome;

    private Double price;

    private Department department;


    public Product() {
    }

    public Product(long id, String nome, Double price, Department department) {
        this.id = id;
        this.nome = nome;
        this.price = price;
        this.department = department;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
