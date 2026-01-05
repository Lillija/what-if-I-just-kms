import java.util.Scanner;

public class MortgageCalculator{
    private int amount;
    private float yearlyRate;
    private int years;

    public MortgageCalculator(int amount, float yearlyRate, int years){
        this.amount = amount;
        this.yearlyRate = yearlyRate;
        this.years = years;
    }

    public double calculate(){
        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;

        int months = this.years * MONTH_IN_YEAR;
        float monthlyRate = this.yearlyRate / PERCENT / MONTH_IN_YEAR;
        double futureValueInterestFactor = Math.pow((1 + monthlyRate), months);

        double monthlyMortgagePayment =
                this.amount * (monthlyRate * futureValueInterestFactor) /
                (futureValueInterestFactor - 1);

        double roundedMonthlyMortgagePayment =
                (double) Math.round(monthlyMortgagePayment * 100d) / 100d;

        return roundedMonthlyMortgagePayment;
    }
}