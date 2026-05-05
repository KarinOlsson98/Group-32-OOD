package se.group32.application;

import java.util.ArrayList;
import java.util.List;

import se.group32.domain.Material;
import se.group32.domain.Product;

public class ProductManager {
    private List<Product> products = new ArrayList<>();
    private int nextId = 1;

    public void addProduct(String name, int lifespan,List<Material> materials) {
        Product newProduct = new Product(nextId, name, lifespan, materials);

        products.add(newProduct);

    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

        System.out.println("Product saved with ID: " + nextId); //För testkörning!!

        nextId++;

    }
}

