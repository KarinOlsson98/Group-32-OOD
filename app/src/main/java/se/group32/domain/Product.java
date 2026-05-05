package se.group32.domain;

public class Product {
    Material material = new Material();

    public String getProductName(int choice) {
        return "Water Bottle";
    }

    public String getProductsMaterials(int choice) {
        return material.getMaterial();
    }

}