package se.group32.presentation;

import se.group32.application.ProductManager;

public class ReportMenu{
    /** ReportMenu ska bli kallad av ProductMenu klassen om 
     *      användaren har valt att beräkna produktens miljöpåverkan eller återvinningsguide:n
     *      Den ska också bli kallad av MaterialMenu om de väljer att se mer av ett/flera material.
     *      Den ska också (nuvarande) fixa outputs:n.*/

    // This method will show a list of available products and ask which of the product that the user wants to calculate the impact of.
    public void impactCalculation(int choice){
        // Prints outputs to show that it's working.
        System.out.println("impactCalculation-metoden kallad...");

        // Relay the index to the productManager to find the right product for calculate.
        // Pre-determined values for testing.
        choice = 17;
        int number = 1000;
        String product = "Vattenflaska";
        String result = "Hög";
        String lifespan = "1 year";

        // Output
        System.out.println("--------------------");
        System.out.println("Product ID: " + choice);
        System.out.println("Product: " + product);
        System.out.printf("The product's enviromental impact is %s with the of score of %d.", result, number + ".");
        System.out.println("Product's lifespan: " + lifespan);
        System.out.println("--------------------");

    }

    // The method will relay the chosen product and print an output that shows their product's recyclingGuidance.
    // It shall contain the Product's ID, Name, Recycling Category and Material (Optional).
    public void showGuidance(int choice, ProductManager pm){
        // Output
        System.out.println("--------------------");
        System.out.println("Product ID : " + choice);
        System.out.println("Product Name : " + pm.getProductName(choice));
        System.out.println("Material(s) : " + pm.getProductsMaterial(choice));
        System.out.println("Recycling Category : " + pm.getRecyclingGuidance(choice));
        System.out.println("--------------------");
    }

    // This method will create the output and relay the parameters to the application layer (materialManager).
    public void showMaterialImpact(int choice) {
        // Prints outputs to show that it's working.
        System.out.println("showMaterial-metoden kallad...");

        // Relay the index to the materialManager to find the right material.
        // Pre-determined values for testing.
        String material1 = "Plast";
        String material2 = "Hög";
        choice = 10;

        // Output
        System.out.println("--------------------");
        System.out.println("Material ID: " + choice);
        System.out.println("Material: " + material1);
        System.out.println("Materialets Impact: " + material2);
        System.out.println("--------------------");
    }

}