package ss12_framework.bai_tap;

public class Product {
    private String id;
    private String name;
    private int price;

    public Product() {
    }

    public Product(String id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public Product setName(String name) {
        this.name = name;
        return this;
    }

    public String getName() {
        return name;
    }

    public Product setPrice(int price) {
        this.price = price;
        return this;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public int getPrice() {
        return price;
    }

    public String getId() {
        return id;
    }
}
