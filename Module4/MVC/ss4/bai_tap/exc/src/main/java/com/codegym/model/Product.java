package com.codegym.model;

public class Product {
    private int id;
    private String name;
    private int price;
    private String status;
    private String manufacturer;

    public Product() {
    }


    public Product(int id, String name, int price, String status, String manufacturer) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.status = status;
        this.manufacturer = manufacturer;
    }

    public int getId() {
        return id;
    }

    public Product setId(int id) {
        this.id = id;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public int getPrice() {
        return price;
    }

    public Product setPrice(int price) {
        this.price = price;
        return this;
    }

    public String getStatus() {
        return status;
    }

    public Product setStatus(String status) {
        this.status = status;
        return this;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public Product setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
        return this;
    }
}
