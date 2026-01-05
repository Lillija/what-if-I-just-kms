import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;

        int totalCreditSum = -1;
        float yearlyPercentageRate = -1;
        int years = -1;

        var scanner = new Scanner(System.in);

        System.out.print("|===> Hipotekārā kredīta kalkulators <===|\n");

        totalCreditSum = (int) readInput("Ievadiet kredīta summu: ", 1000, 10000);
        yearlyPercentageRate = readInput("Ievadiet gada procentu likmi: ", 0, 20);
        years = (int) readInput("Ievadiet periodu gados: ", 5, 30);

        // deleģējām kalkulāciju statiskai metodei
        double roundedMonthlyMortgagePayment = calculateMortgage(
                totalCreditSum,
                yearlyPercentageRate,
                years
        );

        System.out.println("Ikmēneša maksājums: " + roundedMonthlyMortgagePayment + " EUR");
        scanner.close();
    }

    public static double calculateMortgage(int amount, float yearlyRate, int years) {
        final byte MONTH_IN_YEAR = 12;
        final byte PERCENT = 100;

        int months = years * MONTH_IN_YEAR;
        float monthlyRate = yearlyRate / PERCENT / MONTH_IN_YEAR;
        double futureValueInterestFactor = Math.pow((1 + monthlyRate), months);

        double monthlyMortgagePayment =
                amount * (monthlyRate * futureValueInterestFactor) /
                (futureValueInterestFactor - 1);

        double roundedMonthlyMortgagePayment =
                (double) Math.round(monthlyMortgagePayment * 100d) / 100d;

        return roundedMonthlyMortgagePayment;
    }

    public static float readInput(String prompt, int lowerLimit, int higherLimit) {
        var scanner = new Scanner(System.in);
        float input = -1;
        while (true) {
        System.out.println(prompt);
        input = scanner.nextFloat();
        if (input >= lowerLimit && input <= higherLimit) {
        break;
        }
        System.out.println("Incorrect, please try again");
        }
        return input;
        }
}

