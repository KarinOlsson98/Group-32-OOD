package se.group32.domain;

public class Material {
    private int id;
    private String name;

    public Material (int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    // toString() method to prevent returned hashcodes.
    @Override
    public String toString() {
         return name;
    }
}