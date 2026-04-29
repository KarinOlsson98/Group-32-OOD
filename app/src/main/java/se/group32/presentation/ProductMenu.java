package se.group32.presentation;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import se.group32.application.MaterialManager;
import se.group32.application.ProductManager;
import se.group32.domain.Material;
import se.group32.domain.Product;

public class ProductMenu implements MenuInterface{

    private MaterialManager materialManager;
    private ProductManager productManager;
    private ReportMenu reportMenu;
    private Scanner scanner;


    public ProductMenu (MaterialManager materialManager, ProductManager productManager, ReportMenu reportMenu, Scanner scanner) {
        this.materialManager = materialManager;
        this.productManager = productManager;
        this.reportMenu = reportMenu;
        this.scanner = scanner;
    }

    @Override
    public void run () {
        boolean running = true;


        while (running) {
            printMenu();

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

    @Override
    public void printMenu () {
        System.out.println();
        System.out.println("---- Product Menu ----");
        System.out.println(" 1) Create products");
        System.out.println(" 2) List products");
        System.out.println(" 3) Calculate product impact");
        System.out.println(" 4) Recycling guidance");
        System.out.println(" Q) Return to main menu");
        System.out.println("----------------------");
    }

    //Skapar ny produkt med material
    private void createProduct () {
        System.out.println();
        System.out.println("---- Add product ----");

        System.out.println("Enter name of product: ");
        String name = "Teacup"; 
        System.out.println("Lifespan in years: ");
        Integer lifespan = 10; 


        List<Material> materials = new ArrayList<>(); /* materialManager.getMaterials(); */

        System.out.println("Available materials: ");

        if (materials == null || materials.isEmpty()) {
            System.out.println("List of materials is empty");
        } else {
            for (Material m : materials) {
                System.out.println(m);
            }
        }

        boolean adding = true;

        List<String> selectedMaterials = new ArrayList<>();

        while (adding) {
            
            String input = "Plastic"; /*("(Enter one material at a time and press Enter. Type "q" when you are done): ")
            
            /** behöver någon slags koll för att se till att materialet faktiskt finns, hur?
            *   materialManager.exist() som returnerar boolean kanske? 
            */
            System.out.println("Material " + input + " has been added");
            adding = false;//Ligger här för att förhindra oändlig loop vid testning pga hårdkodat material
/* 
            if (input.equalsIgnoreCase("q")) {
                adding = false;
            } else if (materialManager.exists(input)) {
                selectedMaterials.add(input);
                System.out.println("Added: " + input);
            } else {  
                adding = false; //Ligger här för att förhindra oändlig loop vid testning pga hårdkodat material
                System.out.println("Material requested doesn't exist, try again!");

            }*/
        }

        // applicationManager.addProduct(id, name, lifespan, selectedMaterials);

        System.out.println("Product " + name + " has been added!");
        
    }

        private void listProduct() {
        System.out.println();
        System.out.println("---- Product list ----");

        List<Product> products = new ArrayList<>(); /* productManager.getProducts(); */

        if (products == null || products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            for (Product p : products) {
                System.out.println(/*"Product id: " + p.getId() + "Name: " + p.getName() + " | Lifespan: " + p.getLifespan() + " | Materials: " + p.getMaterial()"*/);
            }
        }

    }



    private void calculateImpact() {
        System.out.println();
        System.out.println("---- Impact calculation ----");
        int parsedInput = 0;

        boolean result = false;
        while (!result) {
            listProduct();

            System.out.println();
            System.out.println("Choose the product you would like to calculate by pressing the corresponding index number: ");

            String input = scanner.nextLine();
            result = InputValidator.validateInt(input);
            if (result){
                parsedInput = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Not a valid answer.");
            }
        }

        reportMenu.impactCalculation(parsedInput);

    }

    private void showRecyclingGuidance() {
        System.out.println();
        System.out.println("---- Recycling Guidance ----");
        int parsedInput = 0;
        boolean result = false;
        while (!result) {
            listProduct();

            System.out.println();
            System.out.println("Choose the product you would like to know more about by pressing the corresponding index number: ");

            String input = scanner.nextLine();
            result = InputValidator.validateInt(input);
            if (result){
                parsedInput = Integer.parseInt(input);
                break;
            } else {
                System.out.println("Not a valid answer.");
            }
        }

        reportMenu.showGuidance(parsedInput);
    }
}
