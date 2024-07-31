
public class OptimizedFinancialForecasting {

    // Method to calculate future value using iteration
    public static double calculateFutureValueIteratively(double currentValue, double growthRate, int periods) {
        double futureValue = currentValue;
        for (int i = 0; i < periods; i++) {
            futureValue *= (1 + growthRate);
        }
        return futureValue;
    }

    public static void main(String[] args) {
        double initialValue = 1000.0;  // Initial value
        double annualGrowthRate = 0.05;  // 5% annual growth rate
        int years = 10;  // Number of years to predict

        double futureValue = calculateFutureValueIteratively(initialValue, annualGrowthRate, years);

        System.out.println("Future value after " + years + " years: " + futureValue);
    }
}
