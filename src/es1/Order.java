package es1;

import es1.Interfaces.iProduct;

import java.time.LocalDate;
import java.util.List;
import java.util.StringJoiner;

public class Order implements iProduct {
    private Long id;
    private String status;
    private LocalDate orderDate;
    private LocalDate deliveryDate;
    private List<Product> products;
    private Customer customer;

    public Order() {
        long id = generateid();
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void setOrderDate(LocalDate orderDate) {
        this.orderDate = orderDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", Order.class.getSimpleName() + "[", "]")
                .add("id=" + id)
                .add("status='" + status + "'")
                .add("orderDate=" + orderDate)
                .add("deliveryDate=" + deliveryDate)
                .add("products=" + products)
                .add("customer=" + customer)
                .toString();
    }
}
