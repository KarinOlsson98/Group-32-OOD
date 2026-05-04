package se.group32.application;

import se.group32.domain.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductManager {

    private List<Product> products = new ArrayList<>();

    public List<Product> getProducts() {
        return products;
    }

}
