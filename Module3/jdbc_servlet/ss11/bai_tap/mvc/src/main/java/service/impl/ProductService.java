package service.impl;

import model.Product;
import reponsitory.impl.ProductRepos;
import service.IProductService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProductService implements IProductService {
    ProductRepos productList = new ProductRepos();

    @Override
    public List<Product> findAll() {
        return productList.findAll();
    }

    @Override
    public Map<String,String> save(Product product) {

        Map<String, String> map = new HashMap<>();
        if (product.getPrice()<0){
            map.put("price","tien phai lon hon 0");
        }else if (product.getPrice()>10000){
            map.put("price","tien phai nho hon 10000");
        }
        if (map.isEmpty()){
            productList.save(product);
        }
        return map;
    }

    @Override
    public void remove(Product product) {
       productList.remove(product);
    }

    @Override
    public boolean update(Product product) {
        return productList.update(product);
    }

    @Override
    public Product findById(int id) {
        return productList.findById(id);
    }

    @Override
    public void removeById(int id) {
        productList.remove(findById(id));
    }

    @Override
    public Product findByName(String name) {
        return productList.findByName(name);
    }
}
