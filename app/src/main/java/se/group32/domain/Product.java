package se.group32.domain;

import java.util.List;

public class Product {
    private int id;
    private String name;
    private int lifespan;
    private List<Material> materials;

    public Product(int id, String name, int lifespan, List<Material> materials) {
        this.id = id;
        this.name = name;
        this.lifespan = lifespan;
        this.materials = materials;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getLifespan() {
        return lifespan;
    }

    public List<Material> getMaterials() {
        return materials;
    }
}
