package es1;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {

        Supplier<String> randomCategory = () -> {
            String[] genre = {"Books", "Baby", "Toys", "Clothes", "Boys"};
            Random rnd = new Random();
            return genre[rnd.nextInt(0, genre.length)];
        };

        Supplier<Double> randomPrice = () -> {
            Random rnd = new Random();
            return (double) rnd.nextInt(5, 301);
        };

        Supplier<Product> item = () -> new Product("name", randomCategory.get(), randomPrice.get());

        // creating product list
        List<Product> productList = new ArrayList<>();
        for(int i = 0; i < 10; i++) {
            productList.add(item.get());
        }

        // print list
        productList.forEach(productItem -> System.out.println(productItem));

        // es1
        System.out.println("--------------------- ES1: Books > 100 ------------------------");
        List<Product> listBooksHigher100 = new ArrayList<>();
        productList.stream().filter(product -> product.getPrice() > 100 && product.getCategory().equalsIgnoreCase("books")).forEach(
                listBooksHigher100::add
        );

        System.out.println("books > 100: " + listBooksHigher100);

        // es2
        System.out.println("--------------------- ES2: Baby ------------------------");
        List<Product> listCatgoryBaby = productList.stream().filter(product -> product.getCategory().equalsIgnoreCase("baby")).toList();

        System.out.println("Category Baby: " + listCatgoryBaby);

        // es3
        System.out.println("--------------------- ES3: Boys & price with 10% discount ------------------------");

        List<Product> listBoys = new ArrayList<>();
        productList.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("boys"))
                .forEach(product -> {
                    product.setPrice(product.getPrice() * 0.9);
                    listBoys.add(product);
                });

        System.out.println("Boys & price with 10% discount: " + listBoys);

        // es4
        System.out.println("--------------------- ES4: Order ------------------------");
        Supplier<Integer> randomTier = () -> {
            Random rnd = new Random();
            return rnd.nextInt(1, 4);
        };

        Supplier<LocalDate> randomOrderdDate = () -> {
            Random rnd = new Random();
            LocalDate today = LocalDate.now();
            return today.minusDays(rnd.nextInt(180, 360));
        };

        Supplier<LocalDate> randomDeliveryDate = () -> {
            Random rnd = new Random();
            LocalDate today = LocalDate.now();
            return today.plusDays(rnd.nextInt(0, 31));
        };

        Supplier<Product> randomProduct = () -> {
            Random rnd = new Random();
            return productList.get(rnd.nextInt(0, productList.size()));
        };

        Supplier<Customer> customer = () -> new Customer("name", randomTier.get());

        // crates 10 customers
        List<Customer> listCustomers = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            listCustomers.add(customer.get());
        }

        Supplier<Customer> randomCustomer = () -> {
            Random rnd = new Random();
            return listCustomers.get(rnd.nextInt(0, listCustomers.size()));
        };

        System.out.println("list customers: " + listCustomers);

        Supplier<Order> order = () -> new Order("status", randomOrderdDate.get(), randomDeliveryDate.get(), randomProduct.get(), randomCustomer.get());

        // creates orders
        List<Order> listOrder = new ArrayList<>();
        for(int i = 0; i < 20; i++) {
            listOrder.add(order.get());
        }
        Predicate<LocalDate> isAfterJan = date -> date.isAfter(LocalDate.parse("2023-01-31"));
        Predicate<LocalDate> isBeforeApril = date -> date.isBefore(LocalDate.parse("2023-04-01"));
        Predicate<LocalDate> isBetween = isBeforeApril.and(isAfterJan);

        System.out.println("order list: " + listOrder);

        List<Product> ListLevel2Clients = new ArrayList<>();
        listOrder.stream().filter(ordered -> ordered.getCustomer().getTier() == 2)
                .filter(oreded -> isBetween.test(oreded.getOrderDate())
                ).forEach(oreded -> {
//                    ListLevel2Clients.add(oreded);
                    System.out.println("ordeded: " + oreded);
                });

        System.out.println("filteded: " + ListLevel2Clients);
    }
}