package se.group32.application;
import se.group32.domain.Material;
import java.util.ArrayList; 

public class MaterialManager {
    
    private ArrayList<Material> materials = new ArrayList<Material>();

    public MaterialManager() {
        materials.add(new Material(1, "Plastic")); //Hårdkodat för testning
        materials.add(new Material(2, "Aluminum")); //Hårdkodat för testning
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
}
