package se.group32.presentation;

public class InputValidator {

    // InputValidator class will only check if user's input can be converted to an int.
    public static boolean validateInt(String choice) {
        // Returns a boolean value back to the sub-menus if the user's input is valid/invalid.
        try {
            Integer.parseInt(choice);
            return true;
        } catch (NumberFormatException e) {
            System.out.println("The input that you have selected is not a valid integer.");
            return false;
        }
    }
}
