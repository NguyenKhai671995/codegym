package com.codegym.service.impl;

import com.codegym.model.Product;
import com.codegym.repository.IProductRepository;
import com.codegym.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("productService")
public class ProductService implements IProductService<Product> {
    @Autowired
    private IProductRepository<Product> iProductRepository;

    @Override
    public Product findBy(int id) {
        return iProductRepository.findBy(id);
    }

    @Override
    public List<Product> findAll() {
        return iProductRepository.findAll();
    }

    @Override
    public void save(Product product) {
        this.iProductRepository.save(product);
    }

    @Override
    public void remove(Product product) {

    }

    @Override
    public void update(Product product) {
        iProductRepository.update(product);
    }

    @Override
    public void removeById(int id) {
        iProductRepository.removeById(id);
    }

    @Override
    public List<Product> findByName(String name) {
        return iProductRepository.findByName(name);
    }
}
