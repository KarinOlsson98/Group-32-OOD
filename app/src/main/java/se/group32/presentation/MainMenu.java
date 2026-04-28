package se.group32.presentation;

import java.util.Scanner;

import se.group32.application.ApplicationManager;
import se.group32.application.ProductManager;
import se.group32.application.MaterialManager;

public class MainMenu implements MenuInterface{

    private boolean isRunning = true; 
    
    private Scanner scanner = new Scanner(System.in); 
    private ApplicationManager applicationManager = new ApplicationManager();
    private MaterialManager materialManager = new MaterialManager();
    private ProductManager productManager = new ProductManager();

    private MaterialMenu materialMenu = new MaterialMenu(scanner);
    private ReportMenu reportMenu = new ReportMenu();
    private ProductMenu productMenu = new ProductMenu(applicationManager, materialManager, productManager, reportMenu, scanner);


    @Override
    public void printMenu() {
        System.out.println("\n----- Main Menu -----");
        System.out.println("1) Manage products");
        System.out.println("2) List of materials");
        System.out.println("q) Quit");
        System.out.println("---------------------");
        System.out.print("Choose an option: "); 
    }

    @Override
    public void run() {
        while (isRunning) {
            printMenu(); 
            
            String choice = scanner.nextLine(); 
            
            handleInput(choice); 
        }
    }
    
    private void handleInput(String choice) {
        switch (choice.toLowerCase()) { 
            case "1":
                productMenu.run();
                break;
            case "2":
                materialMenu.run();
                break;
            case "q":
                System.out.println("Quitting program...");
                isRunning = false; 
                break;
            default:
                System.out.println("Invalid option, please try again.");
        }
    }
}


