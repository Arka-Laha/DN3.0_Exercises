public class FinancialForecaster {
    /**
     * Calculate the future value using recursion.
     *
     * @param presentValue The initial investment.
     * @param growthRate   The interest rate.
     * @param periods      The number of periods.
     * @return The future value.
     */
    public static double calculateFutureValue(double presentValue, double growthRate, int periods) {
        // Base case: if there are no more periods, return the present value
        if (periods == 0) {
            return presentValue;
        }
        // Recursive case: calculate the future value for the next period
        else {
            double newPresentValue = presentValue * (1 + growthRate);
            return calculateFutureValue(newPresentValue, growthRate, periods - 1);
        }
    }
}