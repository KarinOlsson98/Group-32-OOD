package se.group32.application;

import se.group32.domain.Product;
import se.group32.domain.RecyclingGuidance;

public class ProductManager {
    Product product = new Product();
    RecyclingGuidance guidance = new RecyclingGuidance();

    // Get recyclingGuidance.
    public String getRecyclingGuidance(int choice) {
        return guidance.getProductGuidance(product);
    }

    public String getProductName(int choice) {
        return product.getProductName(choice);
    }

    public String getProductsMaterial(int choice) {
        return product.getProductsMaterials(choice);
    }

}
