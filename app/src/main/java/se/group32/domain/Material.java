package se.group32.domain;

public class Material {
    private String name;
    private int impactValue; //Borde kanske vara en double
    //private RecyclingCategory recyclingCategory;

    public Material(String name, int impactValue){
        this.name = name;
        this.impactValue = impactValue;
    }
}
