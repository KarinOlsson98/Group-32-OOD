package se.group32.presentation;
import java.util.ArrayList;
import java.util.Scanner;
import se.group32.application.MaterialManager;
import se.group32.domain.Material;

public class MaterialMenu implements MenuInterface{
    /** MaterialMeny ska direkt lista material med deras alternativ som är indexes.
     *      Sedan kommer en fråga om användaren vill se mer information om specifika material.
     *      Om användaren säger ja --> Programmet frågar vilken index eller material som efterfrågas.
     *      Om användaren säger nej --> Programmet skickar tillbaka användaren till huvudmenyn.
     * 
     *      Notera att frågan kommer att upprepas tills användaren vill gå tillbaka till huvudmenyn.
    */
    private Scanner scanner;
    private MaterialManager materialManager;
    private ReportMenu reportMenu;

    //Injects a scanner object from MainMenu class
    public MaterialMenu(MaterialManager materialManager ,ReportMenu reportMenu ,Scanner scanner){
        this.scanner = scanner;
        this.materialManager = materialManager;
        this.reportMenu = reportMenu;
        
    }

    public void run(){
        String selection;
        do{
            printMenu();
            System.out.print("Want to see more info?(y/n)");
            selection = scanner.nextLine();
            choiceSelection(selection);

        }
        while(!(selection.equals("q") || selection.equals("n")));
    }

    public void printMenu(){
        materialManager.addTestMaterial();
        ArrayList<Material> materialList = materialManager.getMaterial();
        for(int i = 0; i < materialList.size(); i++){
            String materialName = materialList.get(i).getName();
            System.out.println((i) + ", " + materialName);
        }
        if (materialList.isEmpty()){
            System.out.println("Empty List");
        }
        // System.out.println("Look at all the material");
        // System.out.println("q to quit");
    }

    private void choiceSelection(String selection){
        switch(selection){
                case "y":
                    System.out.println("Entering material selection");
                    materialSelection();
                    break;
                case "n":
                    System.out.println("Returning to main menu");
                    break;
            }
    }

    private void materialSelection(){
        System.out.println("Enter name/index of material");
        String selection = scanner.nextLine();
    }
}