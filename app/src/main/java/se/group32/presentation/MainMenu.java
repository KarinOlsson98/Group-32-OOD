package se.group32.presentation;

import java.util.Scanner;

public class MainMenu implements MenuInterface{

    private boolean isRunning = true; 
    
    // Tillfällig scanner
    private Scanner scanner = new Scanner(System.in); 

    @Override
    public void printMenu() {
        System.out.println("\n----- Main Menu ----");
        System.out.println("1) Manage products");
        System.out.println("2) List of materials");
        System.out.println("q) Quit");
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
                ProductMenu productMenu = new ProductMenu();
                productMenu.run();
                break;
            case "2":
                MaterialMenu materialMenu = new MaterialMenu();
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


