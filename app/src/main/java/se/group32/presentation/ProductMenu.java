// Johanna
package se.group32.presentation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import se.group32.application.ApplicationManager;
import se.group32.application.MaterialManager;
import se.group32.application.ProductManager;
import se.group32.domain.Product;
import se.group32.domain.Material;

public class ProductMenu implements MenuInterface{
    /** ProduktMenyn ska innehålla:
     *      Eventuellt kan vi lägga till en beskrivning om vad produktmenyn 
     *      1. Skapa produkter
     *      2. Lista produkter
     *      3. Beräkna produktens impact
     *      (4. Återvinningsguide --> Lista produkter som visar produkternas namn,
     *              som sedan visar guide:n och kör en loop. Samma princip som materialmeny.)
     *      qQ. Gå tillbaka till huvudmenyn
     */
    private ApplicationManager applicationManager;
    private MaterialManager materialManager;
    private ProductManager productManager;
    private Validator validator;

    public ProductMenu (ApplicationManager applicationManager, MaterialManager materialManager, ProductManager productManager) {
        this.applicationManager = applicationManager;
        this.materialManager = materialManager;
        this.productManager = productManager;
    }
    public void run () {
        boolean running = true;

        //Tillfällig scanner tills validatorn är igång för att kunna testa.
        Scanner scanner = new Scanner(System.in);


        while (running) {
            printMenu();
            // String choice = Validator.getString("Choice: ").toLowerCase(); ??

            String choice = scanner.nextLine();


            switch (choice) {
                case "1" -> createProduct();
                case "2" -> listProduct();
                case "3" -> calculateImpact();
                case "4" -> showRecyclingGuidance();
                case "q" -> running = false;
                default -> System.out.println("Invalid choice, try again.");
            }

        }
    }

    public void printMenu () {
        System.out.println("---- Product Menu ----");
        System.out.println(" 1) Create products");
        System.out.println(" 2) List products");
        System.out.println(" 3) Calculate product impact");
        System.out.println(" 4) Recycling guidance");
        System.out.println(" Q) Return to main menu");
        System.out.println("----------------------");
    }

    //Skapar ny produkt med material
    public void createProduct () {
        System.out.println("---- Add product ----");

        String name = "Teacup"; //Validator.getString("Name of product: ") ;
        Integer lifespan = 10; //Validator.getInt("Lifespan in years: ");

        List<Material> materials = materialManager.getMaterials();

        System.out.println("Available materials: ");

        if (materials == null || materials.isEmpty()) {
            System.out.println("Materiallist is empty or not initiated.");
        } else {
            for (Material m : materials) {
                System.out.println(m.getName());
            }
        }

        boolean adding = true;

        while (adding) {
            
            String input = "Plastic"; //Validator.getString("Input requested material(Write q when finished): ")
            
            /** behöver någon slags koll för att se till att materialet faktiskt finns, hur?
            *   materialManager.exist() som returnerar boolean kpanske? 
            */

            if (input.equalsIgnoreCase("q")) {
                adding = false;
            } else /*if (materialManager.exists(input)) {
            *    materiallist.add(input);
            *    System.out.println("Added: " + input);
            *} else */ {  
                adding = false; //Ligger här för att förhindra oändlig loop vid testning pga hårdkodat material
                System.out.println("Material requested doesn't exist, try again!");

            }
        }

        //applicationManager.addProduct(name, lifespan, materiallist);

        System.out.println("Product has been added!");
        
    }

    //Listar alla produkter som skapats
    public void listProduct() {
        System.out.println("---- List of Product ----");

        List<Product> products = productManager.getProducts();

        if (products == null || products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            for (Product p : products) {
                System.out.println("Name: " + p.getName() + " | Lifespan: " + p.getLifespan() + " | Materials: " + p.getMaterial());
            }
        }

    }

    public void calculateImpact() {

    }

    public void showRecyclingGuidance() {

    }
}
