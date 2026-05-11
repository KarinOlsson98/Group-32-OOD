package se.group32.application;
import se.group32.domain.Material;
import se.group32.domain.RecyclingGuidance;

import java.util.ArrayList; 

import se.group32.domain.Recyclability;

public class MaterialManager {
    
    private ArrayList<Material> materials = new ArrayList<Material>();
    private RecyclingGuidance rg = new RecyclingGuidance();

    public MaterialManager() {
        materials.add(new Material(1, "Virgin Aluminum", 12.0, Recyclability.High));
        materials.add(new Material(2, "Recycled Aluminum", 1.5, Recyclability.High));
        materials.add(new Material(3, "Virgin Steel", 2.2, Recyclability.High));
        materials.add(new Material(4, "Recycled Steel", 0.4, Recyclability.High));
        materials.add(new Material(5, "PET Plastic", 3.5, Recyclability.Medium));
        materials.add(new Material(6, "HDPE Plastic", 2.0, Recyclability.Medium));
        materials.add(new Material(7, "PVC Plastic", 2.1, Recyclability.Low));
        materials.add(new Material(8, "Virgin Glass", 1.1, Recyclability.High));
        materials.add(new Material(9, "Recycled Glass", 0.64, Recyclability.High));
        materials.add(new Material(10, "Wood (Class 2)", 0.31, Recyclability.Low));
        materials.add(new Material(11, "Paper(Recycled/Board)", 0.50, Recyclability.Medium));
        materials.add(new Material(12, "Cotton (Fabric)", 5.5, Recyclability.Low));
        materials.add(new Material(13, "Natural Rubber", 1.3, Recyclability.Low));
    }

    public ArrayList<Material> getMaterial(){
        return materials;
    }

    public Material getMaterialById (int id) {
        for (Material m : materials) {
            if (m.getId() == id) {
                return m;
            }
        }
        return null;
    }

    // Method calls materialName(String name) to get the corresponding name to Material object, thus return the guidance using the Material object as argument.
    public String getGuidance(String mat) {
        Material m = checkMaterialName(mat);
        return rg.getGuidance(m);
    }

    // Loop through each material that is equals to the String name parameter and return the equivalent Material object.
    public Material checkMaterialName(String name) {
        for (Material material : materials) {
            if (material.getName().equals(name)) {
                return material;
            }
        }
        // If the throw keyword is not allowed (due to output only being on presentation), then return null.
        throw new IllegalArgumentException("Material: " + name + " is invalid.");
    }

}
