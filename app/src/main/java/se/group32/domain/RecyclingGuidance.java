package se.group32.domain;

public class RecyclingGuidance {
    public String getGuidance(Material material) {
        String name = material.getName();

        // Only business logic, shall contain the corresponding recycling guidance for each material.
        if (name.contains("Plastic")) {
            return "Recycle in plastic container.";
        } else if (name.contains("Aluminium")) {
            return "Recycle in metal container.";
        }
        throw new IllegalArgumentException("The material: " + name + " does not have a recycling guidance.");
    }
}
