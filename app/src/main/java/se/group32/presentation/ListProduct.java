package se.group32.presentation;

import java.util.List;

import se.group32.domain.Product;

public class ListProduct {

        public void listProduct() {
        System.out.println("---- Product list ----");

        List<Product> products = productManager.getProducts();

        if (products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            for (Product p : products) {
                System.out.println("Product id: " + p.getId() + "Name: " + p.getName() + " | Lifespan: " + p.getLifespan() + " | Materials: " + p.getMaterial());
            }
        }

    }
}
