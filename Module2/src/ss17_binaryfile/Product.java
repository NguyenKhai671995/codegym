package ss17_binaryfile;

import java.io.Serializable;

public class Product implements Serializable {
    public static final long serialVersionUID = 1;
    public String id;
    public String name;
    public String manufacturer;
    public int price;
    public String other;

    public Product(String id, String name, String manufacturer, int price, String other) {
        this.id = id;
        this.name = name;
        this.manufacturer = manufacturer;
        this.price = price;
        this.other = other;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", manufacturer='" + manufacturer + '\'' +
                ", price=" + price +
                ", other='" + other + '\'' +
                '}';
    }
}
