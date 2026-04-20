// Da Jing
package se.group32.presentation;

public class ReportMenu{
    /** ReportMenu ska bli kallad av ProductMenu klassen om 
     *      användaren har valt att beräkna produktens miljöpåverkan.
     *      Den ska också bli kallad när användaren har valt produktens återvinningsguide.*/

    // This method will show a list of available products.
    public void printProduct() {
        System.out.println("Printar lista på produkter från ListProduct-klassen.");
        // hämtar listan från listprodukt-klassen.
    }

    // This method will show a list of available products and ask which of the product that the user wants to calculate the impact of.
    public void impactCalculation(){
        boolean bool = true;
        while (bool) {
            printProduct();
            System.out.print("Choose the product that you would like to calculate: ");
            String choice = scanner.nextLine();
            // Här kallar jag på parse.int.
            // Här kallar jag på applicationmanager --> kallar vidare till impactcalculationstrategy interface.
            int number = 10;
            System.out.println("Du har valt: " + choice);
            System.out.println("Beräknar produkten...");
            System.out.println("Produkten beräknad: " + number);
            System.out.print("Would you like to calculate another product? Yes/No");
            String c = scanner.nextLine();
            if (c.equalsIgnoreCase("no")) {
                bool = false;
            }
        }
    }

    // This method will show a list of available products and ask which of the product that the user wants to show guide of.
    public void showGuidance(){
        boolean bool = true;
        while (bool) {
            printProduct();
            System.out.print("Choose the product that you would like to show guide: ");
            String choice = scanner.nextLine();
            // Här kallar jag på parse.int.
            // Här kallar jag på applicationmanager --> kallar vidare till showguidance.
            String guide = "Det här är en guide!";
            System.out.println("Du har valt: " + choice);
            System.out.println("Hämtar guide:n...");
            System.out.println("Visar guide:n...");
            System.out.println("Guide:n visas: " + guide);
            System.out.print("Would you like to see another guide? ");
            String c = scanner.nextLine();
            if (c.equalsIgnoreCase("no")) {
                bool = false;
            }                 
        }
    }

}
