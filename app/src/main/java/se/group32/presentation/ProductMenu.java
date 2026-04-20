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
                case "2" -> ListProduct.listProduct();
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

        Integer id = 1; //validator.getint
        String name = "Teacup"; //Validator.getString("Name of product: ") ;
        Integer lifespan = 10; //Validator.getInt("Lifespan in years: ");


        List<Material> materials = materialManager.getMaterials();

        System.out.println("Available materials: ");

        if (materials.isEmpty()) {
            System.out.println("List of materials is empty");
        } else {
            for (Material m : materials) {
                System.out.println(m.getName());
            }
        }

        boolean adding = true;

        List<String> selectedMaterials = new ArrayList<>();

        while (adding) {
            
            String input = "Plastic"; //Validator.getEnum("(Enter one material at a time and press Enter. Type "q" when you are done): ")
            
            /** behöver någon slags koll för att se till att materialet faktiskt finns, hur?
            *   materialManager.exist() som returnerar boolean kanske? 
            */


            if (input.equalsIgnoreCase("q")) {
                adding = false;
            } else if (materialManager.exists(input)) {
                selectedMaterials.add(input);
                System.out.println("Added: " + input);
            } else {  
                adding = false; //Ligger här för att förhindra oändlig loop vid testning pga hårdkodat material
                System.out.println("Material requested doesn't exist, try again!");

            }
        }

        applicationManager.addProduct(id, name, lifespan, selectedMaterials);

        System.out.println("Product has been added!");
        
    }


    public void calculateImpact() {
        System.out.println("---- Impact calculation ----");
        reportMenu.impactCalculation(); ////Ändra namn beroende på namn på metod i reportmenu.
    }

    public void showRecyclingGuidance() {
        System.out.println("---- Recycling Guidance ----");
        reportMenu.showGuidance(); //Ändra namn beroende på namn på metod i reportmenu.
    }
}
