package service;

import model.Product;

import java.util.List;
import java.util.Map;

public interface IProductService {
    List<Product> findAll();

    Map<String,String> save(Product product);

    void remove(Product product);

    boolean update(Product product);

    Product findById(int id);

    void removeById(int id);

    Product findByName(String name);

}
