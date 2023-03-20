package com.codegym.repository.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ProductRepository implements IProductRepository<Product> {
    static List<Product> productList = new ArrayList<>();

    static {
        productList.add(new Product(1, "iphone", 654, "on", "apple"));
        productList.add(new Product(2, "samsung", 123, "on", "samsung"));
        productList.add(new Product(3, "nokia", 456, "off", "nokia"));
        productList.add(new Product(4, "kiaMorning", 987, "off", "vinFast"));
    }


    @Override
    public Product findBy(int id) {
        for (Product product : productList) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    @Override
    public List<Product> findAll() {
        return productList;
    }

    @Override
    public void save(Product product) {
        productList.add(product);
    }

    @Override
    public void remove(Product product) {

    }

    @Override
    public void update(Product product) {
        findBy(product.getId()).
                setName(product.getName()).
                setPrice(product.getPrice()).
                setManufacturer(product.getManufacturer()).
                setStatus(product.getStatus());
    }

    @Override
    public void removeById(int id) {
        productList.remove(findBy(id));
    }

    @Override
    public List<Product> findByName(String name) {
        List<Product> products = new ArrayList<>();
        for (Product pro : productList){
            if (pro.getName().equalsIgnoreCase(name)){
                products.add(pro);
            }
        }
        return products;
//        return productList.stream().filter(x -> x.getName().equalsIgnoreCase(name)).findFirst().orElse(null);
    }
}
