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

    private ApplicationManager applicationManager;
    private MaterialManager materialManager;
    private ProductManager productManager;
    private ReportMenu reportMenu;
    private Scanner scanner;
    // private Validator validator;


    public ProductMenu (ApplicationManager applicationManager, MaterialManager materialManager, ProductManager productManager, ReportMenu reportMenu, Scanner scanner/*, Validator validator*/) {
        this.applicationManager = applicationManager;
        this.materialManager = materialManager;
        this.productManager = productManager;
        this.reportMenu = reportMenu;
        this.scanner = scanner;
        // this.validator = validator; 
    }

    public void run () {
        boolean running = true;


        while (running) {
            printMenu();
            // String choice = Validator.getString("Choice: ").toLowerCase();

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
    public void createProduct () {
        System.out.println();
        System.out.println("---- Add product ----");

        System.out.println("Enter name of product: ");
        String name = "Teacup"; //Validator.getString("Name of product: ") ;
        System.out.println("Lifespan in years: ");
        Integer lifespan = 10; //Validator.getInt("Lifespan in years: ");


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
            
            String input = "Plastic"; //Validator.getEnum("(Enter one material at a time and press Enter. Type "q" when you are done): ")
            
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

        public void listProduct() {
        System.out.println();
        System.out.println("---- Product list ----");

        List<Product> products = new ArrayList<>(); /* productManager.getProducts(); */

        if (products == null || products.isEmpty()) {
            System.out.println("No products found.");
        } else {
            for (Product p : products) {
                System.out.println(p /*"Product id: " + p.getId() + "Name: " + p.getName() + " | Lifespan: " + p.getLifespan() + " | Materials: " + p.getMaterial()"*/);
            }
        }

    }



    public void calculateImpact() {
        System.out.println();
        System.out.println("---- Impact calculation ----");
        listProduct();
        System.out.println("Choose the product you would like to calculate by pressing the corresponding index number: ");
        //validator.int för att validera input
        /*Få en INT - input om vilken produkt som vill väljas */
        //reportMenu.impactCalculation(/*input*/); ////Ändra namn beroende på namn på metod i reportmenu.
    }

    public void showRecyclingGuidance() {
        System.out.println();
        System.out.println("---- Recycling Guidance ----");
        listProduct();
        System.out.println("Choose the product you would like to know more about by pressing the corresponding index number: ");
        /*validator.int för att validera input
        Få en INT - input om vilken produkt som vill väljas */
        //reportMenu.productGuide(/*input*/); //Ändra namn beroende på namn på metod i reportmenu.
    }
}
