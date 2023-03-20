package ss12_framework.bai_tap;

import java.util.ArrayList;
import java.util.List;

public class ProductManager {
    public List<Product> products;

    public ProductManager() {
        products = new ArrayList<>();
    }

    public void addNew(Product newProduct) {
        if (isNotExistProduct(newProduct.getId())) {
            products.add(newProduct);
        }
    }

    public boolean isNotExistProduct(String id) {
        return searchById(id) == null;
    }

    public Product searchById(String id) {
        for (Product pro : products) {
            if (pro.getId().equalsIgnoreCase(id)) {
                return pro;
            }
        }
        return null;
    }

    public void editById(String id, String newName, int newPrice) {
        searchById(id).setName(newName).setPrice(newPrice);
    }

    public void deleteById(String id) {
        products.remove(searchById(id));
    }

    public void displayList() {
        for (Product pro : products) {
            System.out.println(pro);
        }
    }

    public Product searchByName(String name) {
        for (Product pro : products) {
            if (pro.getName().equalsIgnoreCase(name)) {
                return pro;
            }
        }
        return null;
    }

    public void sortPriceToLow() {
        products.sort((a, b) -> a.getPrice() - b.getPrice());
    }

    public void sortPriceToHigh() {
        products.sort((a, b) -> b.getPrice() - a.getPrice());
    }
}
