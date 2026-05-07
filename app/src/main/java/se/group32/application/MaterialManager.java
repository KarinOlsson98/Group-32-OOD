package se.group32.application;
import se.group32.domain.Material;
import se.group32.domain.RecyclingGuidance;

import java.util.ArrayList; 

public class MaterialManager {
    
    private ArrayList<Material> materials = new ArrayList<Material>();
    private RecyclingGuidance rg = new RecyclingGuidance();

    public MaterialManager() {
        materials.add(new Material(1, "Plastic")); //Hårdkodat för testning
        materials.add(new Material(2, "Aluminium")); //Hårdkodat för testning
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
        throw new IllegalArgumentException("The material: " + name + " was not found.");
    }

    // Get the product's name by searching their corresponding ID.
    public String materialName(int id) {
        for (Material material : materials) {
            if (material.getId() == id) {
                return material.getName();
            }
        }
        // If the throw keyword is not allowed (due to output only being on presentation), then return null.
        throw new IllegalArgumentException("The material's name was not found.");
    }

}
