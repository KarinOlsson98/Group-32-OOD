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
        System.out.println("Product saved with ID: " + nextId); //För testkörning!!

        nextId++;
    }

    public List<Product> getProducts() {
        return products;
    }

    // Get the product's name by searching their corresponding ID.
    public String productName(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                return product.getName();
            }
        }
        // If the throw keyword is not allowed (due to output only being on presentation), then return null.
        throw new IllegalArgumentException("Product with ID: " + id + " is invalid.");
    }

    // Get the product's material by searching their corresponding ID.
    public List<String> productsMaterials(int id) {
        for (Product product : products) {
            if (product.getId() == id) {
                // Empty list that will store all the product's materials' names. 
                List<String> mats = new ArrayList<>();
                for (Material material : product.getMaterials()) {
                    mats.add(material.getName());
                }
                return mats;
            }
        }
        // If the throw keyword is not allowed (due to output only being on presentation), then return null.
        throw new IllegalArgumentException("Product with ID: " + id + "is invalid");
    }
}

