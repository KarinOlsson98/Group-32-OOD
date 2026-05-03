package se.group32.application;
import se.group32.domain.Material;
import java.util.ArrayList; 

public class MaterialManager {
    
    ArrayList<Material> materials = new ArrayList<Material>();

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
