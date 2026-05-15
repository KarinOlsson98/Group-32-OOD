package se.group32.presentation;

import se.group32.application.*; // Assume that we only have Material- and ProductManager classes only.
import se.group32.domain.ImpactCalculationStrategy;
import se.group32.domain.Product;
import se.group32.domain.SimpleSumStrategy;
import se.group32.domain.WeightedByLifespanStrategy;

public class ReportMenu{
    /** ReportMenu ska bli kallad av ProductMenu klassen om 
     *      användaren har valt att beräkna produktens miljöpåverkan eller återvinningsguide:n
     *      Den ska också bli kallad av MaterialMenu om de väljer att se mer av ett/flera material.
     *      Den ska också (nuvarande) fixa outputs:n.*/

    // This method will show a list of available products and ask which of the product that the user wants to calculate the impact of.
    public void impactCalculation(int choice, ProductManager pm){
        Product selectedProduct = null;
        for (Product p: pm.getProducts()) {
            if (p.getId() == choice) {
                selectedProduct = p;
                break;
            }
        }

            if (selectedProduct != null) {
                ImpactCalculationStrategy rawStrategy = new SimpleSumStrategy();
                ImpactCalculationStrategy annualStrategy = new WeightedByLifespanStrategy();

                double rawImpact = rawStrategy.calculateImpact(selectedProduct);
                double annualImpact = annualStrategy.calculateImpact(selectedProduct);

                System.out.println("--------------------");
                System.out.println("Product ID: " + choice);
                System.out.println("Product: " + selectedProduct.getName());
                System.out.printf("Total Raw Impact: %.2f kg CO2.%n", rawImpact);
                System.out.printf("Annual impact: %.2f kg CO2e / year.%n", annualImpact);
                System.out.println("Product's lifespan: " + selectedProduct.getLifespan()+ " years");
                System.out.println("--------------------");
            } else {
                System.out.println("Could not find a product with ID " + choice);
            }
        }
        

    

    // This method will create the output and relay the parameters to the application layer (productManager).
    public void showProductsRecyclingGuidance(int choice, ProductManager pm, MaterialManager mm){

        try {
            System.out.println("---- ♻️  Recycling Guidance for " + pm.productName(choice) + " ----");
            System.out.println("Product ID: " + choice);
            System.out.println("Material(s):");
            for (String material : pm.productsMaterials(choice)) {
                System.out.println(material + " ➡️  " + mm.getGuidance(material));
            }
            System.out.println("--------------------");

        } catch (IllegalArgumentException e) {
            System.out.println("Recycling Guidance error: " + e.getMessage());
        }
    }

    // This method will create the output and relay the parameters to the application layer (materialManager).
    public void showMaterialImpact(int choice) {
        // Prints outputs to show that it's working.
        System.out.println("showMaterial-metoden kallad...");
        System.out.println("Beepboop...");

        // Relay the index to the materialManager to find the right material.
        // Pre-determined values for testing.
        String material1 = "Plast";
        String material2 = "Hög";

        // Output
        System.out.println("--------------------");
        System.out.println("Material ID: " + choice);
        System.out.println("Material: " + material1);
        System.out.println("Materialets Impact: " + material2);
        System.out.println("--------------------");
    }

}