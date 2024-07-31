
public class FinancialForecastingRecursive {
	// Method to calculate future value recursively
    public static double calculateFutureValue(double currentValue, double growthRate, int periods) {
        // Base case: if periods are 0, return the current value
        if (periods == 0) {
            return currentValue;
        }

        // Recursive case: calculate the value for the next period
        return calculateFutureValue(currentValue * (1 + growthRate), growthRate, periods - 1);
    }

    public static void main(String[] args) {
        double initialValue = 1000.0;  // Initial value
        double annualGrowthRate = 0.05;  // 5% annual growth rate
        int years = 10;  // Number of years to predict

        double futureValue = calculateFutureValue(initialValue, annualGrowthRate, years);

        System.out.println("Future value after " + years + " years: " + futureValue);
    }
}
