package es1;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
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
                book -> listBooksHigher100.add(book)
        );

        System.out.println("books > 100: " + listBooksHigher100);

        // es2
        System.out.println("--------------------- ES2: Baby ------------------------");
        List<Product> listCatgoryBaby = productList.stream().filter(product -> product.getCategory().equalsIgnoreCase("baby")).toList();

        System.out.println("Category Baby: " + listCatgoryBaby);

        // es3
        System.out.println("--------------------- ES3: Boys & price with 10% discount ------------------------");
//        List<Product> listBoys = productList.stream()
//                .filter(product -> product.getCategory().equalsIgnoreCase("boys")).toList();
//
//        System.out.println("before: Boys: " + listBoys);
//
//        listBoys.stream().forEach(product -> product.setPrice(product.getPrice() - product.getPrice() * 0.1));
//        List<Product> listBoys1 = new ArrayList<>(listBoys);

        List<Product> listBoys = new ArrayList<>();
        productList.stream()
                .filter(product -> product.getCategory().equalsIgnoreCase("boys"))
                .forEach(product -> {
                    product.setPrice(product.getPrice() * 0.9);
                    listBoys.add(product);
                });

        System.out.println("Boys & price with 10% discount: " + listBoys);
    }

    public static String rndGenre() {
        String[] genre = {"Books", "Baby", "Toys", "Clothes"};
        Random rnd = new Random();
        return genre[rnd.nextInt(0, genre.length + 1)];
    }

    public static double rndPrice() {
        Random rnd = new Random();
        return rnd.nextInt(5, 301);
    }
}