package lt.swedbank.itacademy.lecture2task.task4;

import java.util.Arrays;
import java.util.Scanner;

public class CompoundInterestCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Amount: ");
        double amount = scanner.nextDouble();
        System.out.print("Period length (years): ");
        int periodInYears = scanner.nextInt();
        System.out.print("Compound frequency: ");
        int compoundFrequency = findCompoundFrequency(scanner.next());

        double interestRate;
        double[] interestRateArray = new double[0];
        int elements = 0;
        do {
            System.out.print("Interest rate (%): ");
            interestRate = scanner.nextDouble();
            if (interestRate != 0) {
                interestRateArray = Arrays.copyOf(interestRateArray, elements + 1);
                interestRateArray[elements] = interestRate;
                elements++;
            }
        } while (interestRate != 0);

        for (int i = 0; i < elements; i++) {
            for (double calculatedValue : calculateIntermediateInterestAmount(amount, interestRateArray[i], periodInYears, compoundFrequency)) {
                System.out.printf("%.2f ", calculatedValue);
            }
            System.out.println();
        }

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
