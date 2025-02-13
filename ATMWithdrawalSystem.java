import java.util.Scanner;

class InvalidPINException extends Exception {
    public InvalidPINException(String message) {
        super(message);
    }
}

class InsufficientBalanceException extends Exception {
    public InsufficientBalanceException(String message) {
        super(message);
    }
}

public class ATMWithdrawalSystem {
    private static final int CORRECT_PIN = 1234;
    private static double balance = 5000.00; // Initial balance

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.print("Enter your PIN: ");
            int enteredPin = scanner.nextInt();

            if (enteredPin != CORRECT_PIN) {
                throw new InvalidPINException("Invalid PIN. Access denied.");
            }

            System.out.print("Enter withdrawal amount: ");
            double withdrawalAmount = scanner.nextDouble();

            if (withdrawalAmount > balance) {
                throw new InsufficientBalanceException("Insufficient balance.");
            }

            balance -= withdrawalAmount;
            System.out.println("Withdrawal successful! Amount withdrawn: $" + withdrawalAmount);
        } catch (InvalidPINException | InsufficientBalanceException e) {
            System.out.println("Error: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Invalid input! Please enter valid numeric values.");
        } finally {
            System.out.println("Remaining balance: $" + balance);
            scanner.close();
        }
    }
}
