package se.group32.domain;

public class Material {
    private int id;
    private String name;
    private double impact;
    private Recyclability recyclability;


    public Material (int id, String name, double impact, Recyclability recyclability) {
        this.id = id;
        this.name = name;
        this.impact = impact;
        this.recyclability = recyclability;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public double getImpact () {
        return impact;
    }

    public Recyclability getRecyclability () {
        return recyclability;
    }

    // toString() method to prevent returned hashcodes.
    @Override
    public String toString() {
         return name;
    }
}