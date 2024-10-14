import java.util.Scanner;

// Class representing a user's bank account
class BankAccount {
    private double balance;

    // Constructor to initialize the account balance
    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Initial balance cannot be negative.");
            this.balance = 0;
        }
    }

    // Method to deposit money
    public void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("Successfully deposited: $" + amount);
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("Successfully withdrew: $" + amount);
        } else if (amount > balance) {
            System.out.println("Insufficient balance. Transaction failed.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Method to check the current balance
    public double getBalance() {
        return balance;
    }
}

// Class representing the ATM
class ATM {
    private BankAccount account;

    // Constructor to initialize the ATM with a user's bank account
    public ATM(BankAccount account) {
        this.account = account;
    }

    // Method to show ATM options
    public void showMenu() {
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("\n--- ATM Menu ---");
            System.out.println("1. Check Balance");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Exit");
            System.out.print("Choose an option (1-4): ");

            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    checkBalance();
                    break;
                case 2:
                    System.out.print("Enter the amount to deposit: ");
                    double depositAmount = scanner.nextDouble();
                    deposit(depositAmount);
                    break;
                case 3:
                    System.out.print("Enter the amount to withdraw: ");
                    double withdrawAmount = scanner.nextDouble();
                    withdraw(withdrawAmount);
                    break;
                case 4:
                    exit = true;
                    System.out.println("Thank you for using the ATM. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
        scanner.close();
    }

    // Method to check balance
    public void checkBalance() {
        System.out.println("Current Balance: $" + account.getBalance());
    }

    // Method to deposit money
    public void deposit(double amount) {
        account.deposit(amount);
    }

    // Method to withdraw money
    public void withdraw(double amount) {
        account.withdraw(amount);
    }
}

// Main class to run the ATM system
public class ATMSystem {
    public static void main(String[] args) {
        // Create a bank account with an initial balance
        BankAccount userAccount = new BankAccount(1000.0);

        // Create an ATM and link it to the user's account
        ATM atm = new ATM(userAccount);

        // Show the ATM menu
        atm.showMenu();
    }
}
