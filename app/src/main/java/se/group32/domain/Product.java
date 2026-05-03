package se.group32.domain;

public class Product {
    Material material = new Material();

    public String get_product_name_dj(int choice) {
        return "Water Bottle";
    }

    public String getProductsMaterials_dj(int choice) {
        return material.getMaterial_dj();
    }

}