package se.group32.application;
import se.group32.domain.Material;
import java.util.ArrayList; 

public class MaterialManager {
    ArrayList<Material> materials = new ArrayList<Material>();

    public ArrayList<Material> getMaterial(){
        return materials;
    }
}
