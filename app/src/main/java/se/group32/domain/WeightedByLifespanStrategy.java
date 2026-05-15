package se.group32.domain;

public class WeightedByLifespanStrategy implements ImpactCalculationStrategy {

    @Override
    public double calculateImpact(Product product) {
        // We use the first strategy to calculate PCFraw
        SimpleSumStrategy simpleSum = new SimpleSumStrategy();
        double pcfRaw = simpleSum.calculateImpact(product);

        // Safety net: Prevent division by zero if lifespan is not set properly
        if (product.getLifespan() <= 0) {
            return pcfRaw;
        }

        // Returns PCFannual (PCF / L)
        return pcfRaw / product.getLifespan();
    }
}
