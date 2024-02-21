import java.util.Scanner;

public class ATM {
    private double balance;
    private int pin;

    public ATM(double initialBalance, int pin) {
        balance = initialBalance;
        this.pin = pin;
    }

    public void deposit(double amount) {
        balance += amount;
    }

    public void withdraw(double amount) {
        if (amount <= balance) {
            balance -= amount;
        } else {
            System.out.println("Insufficient funds");
        }
    }

    public void changePin(int newPin) {
        pin = newPin;
    }

    public void displayBalance() {
        System.out.println("Current balance: $" + balance);
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the ATM");
        System.out.print("Enter your PIN: ");
        int enteredPin = scanner.nextInt();

        if (enteredPin == pin) {
            System.out.println("PIN accepted");
            boolean exit = false;

            while (!exit) {
                System.out.println("\nPlease select an option:");
                System.out.println("1. Deposit");
                System.out.println("2. Withdraw");
                System.out.println("3. Change PIN");
                System.out.println("4. Display Balance");
                System.out.println("5. Exit");

                int option = scanner.nextInt();

                switch (option) {
                    case 1:
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        deposit(depositAmount);
                        System.out.println("Deposit successful");
                        break;
                    case 2:
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        withdraw(withdrawAmount);
                        break;
                    case 3:
                        System.out.print("Enter new PIN: ");
                        int newPin = scanner.nextInt();
                        changePin(newPin);
                        System.out.println("PIN changed successfully");
                        break;
                    case 4:
                        displayBalance();
                        break;
                    case 5:
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid option");
                        break;
                }
            }
        } else {
            System.out.println("Invalid PIN");
        }

        scanner.close();
        System.out.println("Thank you for using the ATM");
    }

    public static void main(String[] args) {
        ATM atm = new ATM(1000.0, 1203);
        atm.start();
    }
}
