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
        String name = scanner.nextLine(); 

        int lifespan = 0;
        boolean validLifespan = false;

        while (!validLifespan) {
            System.out.println("Lifespan in years: ");
            String input = scanner.nextLine();

            validLifespan = InputValidator.validateInt(input);

            if (validLifespan) {
                lifespan = Integer.parseInt(input);
            } else {
                System.out.println("Not a valid lifespan, enter an integer number.");
            }
        }

        System.out.println("Available materials: ");

        List<Material> materials = materialManager.getMaterials();

        if (materials == null || materials.isEmpty()) {
            System.out.println("List of materials is empty");
        } else {
            for (Material m : materials) {
                System.out.println("ID: " + m.getId() + "name: " + m.getName());
            }
        }

        boolean adding = true;

        List<Material> selectedMaterials = new ArrayList<>();

        while (adding) {
            
            System.out.println("Enter ID of material you would like to add(or 'q' to finish): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("q")) {
                adding = false;
            } else {
                if (InputValidator.validateInt(input)) {
                    int id = Integer.parseInt(input);

                    Material found = materialManager.getMaterialById(id);

                    if (found != null) {
                        selectedMaterials.add(found);
                        System.out.println("Added: " + found.getName());
                    } else {
                        System.out.println("No material found with ID: " + id);
                    }
                } else {
                    System.out.println("Invalid input. Please enter a number or 'q'.");
                }
            }
        }
        if (!selectedMaterials.isEmpty()) {
            productManager.addProduct(name, lifespan, selectedMaterials);
            System.out.println("Product '" + name + "' has been successfully created!");
        } else {
            System.out.println("No materials selected, product hasn't been created.");
        }
        
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
