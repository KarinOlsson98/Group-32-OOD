package se.group32.presentation;

import se.group32.application.*; // Assume that we only have Material- and ProductManager classes only.
import se.group32.domain.RecyclingGuidance;

public class ReportMenu{
    /** ReportMenu ska bli kallad av ProductMenu klassen om 
     *      användaren har valt att beräkna produktens miljöpåverkan eller återvinningsguide:n
     *      Den ska också bli kallad av MaterialMenu om de väljer att se mer av ett/flera material.
     *      Den ska också (nuvarande) fixa outputs:n.*/

    // This method will show a list of available products and ask which of the product that the user wants to calculate the impact of.
    public void impactCalculation(int choice){
        // Prints outputs to show that it's working.
        System.out.println("impactCalculation-metoden kallad...");
        System.out.println("Beepboop...");

        // Relay the index to the productManager to find the right product for calculate.
        // Pre-determined values for testing.
        int number = 1000;
        String product = "Vattenflaska";
        String result = "Hög";
        String lifespan = "1 year";

        // Output
        System.out.println("--------------------");
        System.out.println("Product ID: " + choice);
        System.out.println("Product: " + product);
        System.out.printf("The product's enviromental impact is %s with the of score of %d%n.", result, number);
        System.out.println("Product's lifespan: " + lifespan);
        System.out.println("--------------------");

    }

    // This method will create the output and relay the parameters to the application layer (productManager).
    public void showProductsRecyclingGuidance(int choice, ProductManager pm){
        // Output
        System.out.println("--------------------");
        System.out.println("Product ID: " + choice);
        System.out.println("Product: " + pm.productName(choice) + "\n");

        // Iterate if there is multiple materials for one product.
        System.out.print("Material(s):\n");
        for (String material : pm.productsMaterials(choice)) {
            try {
                System.out.println(material);
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
        System.out.println("--------------------");
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