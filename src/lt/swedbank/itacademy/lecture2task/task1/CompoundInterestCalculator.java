package lt.swedbank.itacademy.lecture2task.task1;

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

        System.out.println();
        System.out.printf("Total interest amount: %.2f\n", calculateInterestAmount(amount, interestRate, periodInYears));
        System.out.printf("Total amount: %.2f\n", calculateTotalAmount(amount, interestRate, periodInYears));
    }

    private static double calculateInterestAmount(double amount, double interetRate, int periodInYears) {
        return calculateTotalAmount(amount, interetRate, periodInYears) - amount;
    }

    private static double calculateTotalAmount(double amount, double interestRate, int periodInYears) {
        return amount * Math.pow(1 + interestRate / 100, periodInYears);
    }
}
