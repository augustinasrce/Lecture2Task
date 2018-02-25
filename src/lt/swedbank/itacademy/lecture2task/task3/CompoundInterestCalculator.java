package lt.swedbank.itacademy.lecture2task.task3;

import java.util.Arrays;
import java.util.Scanner;

public class CompoundInterestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Amount: ");
        double amount = scanner.nextDouble();
        System.out.print("Interest rate (%): ");
        double interestRate = scanner.nextDouble();
        System.out.print("Period length (years): ");
        int periodInYears = scanner.nextInt();
        System.out.print("Compound frequency: ");
        int compoundFrequency = findCompoundFrequency(scanner.next());

        double totalAmount = calculateTotalAmount(amount, interestRate, periodInYears, compoundFrequency);
        System.out.println();
        System.out.println("Intermediate interest amounts: " + Arrays.toString(calculateIntermediateInterestAmount(amount, interestRate, periodInYears, compoundFrequency)));
        System.out.printf("Total interest amount: %.2f\n", calculateInterestAmount(amount, totalAmount));
        System.out.printf("Total amount: %.2f\n", totalAmount);
    }

    private static double[] calculateIntermediateInterestAmount(double amount, double rate, int periodInYears, int compoundFrequency) {
        double[] intermediateInterests = new double[compoundFrequency * periodInYears];
        double intermediateTotalAmount;
        for (int i = 0; i < compoundFrequency * periodInYears; i++) {
            intermediateTotalAmount = calculateIntermediateTotalAmount(amount, rate);
            intermediateInterests[i] = calculateInterestAmount(amount, intermediateTotalAmount);
            amount = intermediateTotalAmount;
        }
        return intermediateInterests;
    }

    private static double calculateInterestAmount(double amount, double totalAmount) {
        return totalAmount - amount;
    }

    private static double calculateTotalAmount(double amount, double interestRate, int periodInYears, int compoundFrequency) {
        return amount * Math.pow(1 + (interestRate / 100 / compoundFrequency), periodInYears * compoundFrequency);
    }

    private static double calculateIntermediateTotalAmount(double amount, double interestRate) {
        return amount * (1 + interestRate / 100);
    }

    private static int findCompoundFrequency(String compountFrequencyCode) {
        switch (compountFrequencyCode) {
            case "D":
                return 365;
            case "W":
                return 52;
            case "M":
                return 12;
            case "Q":
                return 4;
            case "H":
                return 2;
            case "Y":
                return 1;
            default:
                return 1;
        }
    }
}
