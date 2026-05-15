package se.group32.domain;

public class SimpleSumStrategy implements ImpactCalculationStrategy {

    @Override
    public double calculateImpact(Product product) {
        double totalRawImpact = 0.0;

        // Temporary hardcoding as agreed upon in the group (1 kg per material)
        double assumedMassInKg = 1.0;

        for (Material material : product.getMaterials()) {
            //Formula: Ci = mi * EFi
            totalRawImpact += (assumedMassInKg * material.getImpact());
        }

        return totalRawImpact;
    }
}
