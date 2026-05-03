package se.group32.application;

import se.group32.domain.Product;
import se.group32.domain.RecyclingGuidance;

// import se.group32.domain.RecyclingGuidance;
// import se.group32.domain.Product;

public class ProductManager {
    Product product = new Product();
    RecyclingGuidance guidance = new RecyclingGuidance();

    // Get recyclingGuidance.
    public String getRecyclingGuidance_dj(int choice) {
        return guidance.get_product_guidance(product);
    }

    public String getProductName_dj(int choice) {
        return product.get_product_name_dj(choice);
    }

    public String getProductsMaterials_dj(int choice) {
        return product.getProductsMaterials(choice);
    }

}
