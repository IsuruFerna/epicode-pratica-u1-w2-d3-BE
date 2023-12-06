package es1;

import es1.Interfaces.iProduct;

import java.util.StringJoiner;

public class Product implements iProduct {
    private final Long id;
    private String name;
    private String category;
    private double price;

    public Product (String name, String category, double price) {
        this.id = generateid();
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public double getPrice() {
        return price;
    }

    public String getCategory() {
        return category;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Product.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("name='" + name + "'")
                .add("category='" + category + "'")
                .add("price=" + price)
                .toString();
    }
}
