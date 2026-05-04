package se.group32.application;
import se.group32.domain.Material;
import java.util.ArrayList; 

public class MaterialManager {
    ArrayList<Material> materials = new ArrayList<Material>();

    //En funktion för att testa lägga in material, temp tills ny lösning uppstår
    public void addTestMaterial(){
        Material plastic = new Material("plastic", 2);
        Material wood = new Material("wood", 1);
        materials.add(plastic);
        materials.add(wood);
    }

    public ArrayList<Material> getMaterial(){
        return materials;
    }
}
