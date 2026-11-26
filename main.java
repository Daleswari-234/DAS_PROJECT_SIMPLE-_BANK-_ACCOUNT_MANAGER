import java.util.ArrayList;
import java.util.Scanner;

class BankAccount {
    int accountNumber;
    String name;
    double balance;

    BankAccount(int accountNumber, String name, double balance) {
        this.accountNumber = accountNumber;
        this.name = name;
        this.balance = balance;
    }

    void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + name);
        System.out.println("Balance: Rs. " + balance);
    }
}

public class BankAccountManager {

    static ArrayList<BankAccount> accounts = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {

        int choice;

        do {
            System.out.println("\n===== BANK ACCOUNT MANAGER =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. Check Balance");
            System.out.println("5. Display All Accounts");
            System.out.println("6. Exit");

            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) {

                case 1:
                    createAccount();
                    break;

                case 2:
                    deposit();
                    break;

                case 3:
                    withdraw();
                    break;

                case 4:
                    checkBalance();
                    break;

                case 5:
                    displayAccounts();
                    break;

                case 6:
                    System.out.println("Thank You for Using Bank Manager!");
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }

        } while (choice != 6);
    }

    static void createAccount() {

        System.out.print("Enter Account Number: ");
        int number = sc.nextInt();

        System.out.print("Enter Account Holder Name: ");
        String name = sc.next();

        System.out.print("Enter Initial Balance: ");
        double balance = sc.nextDouble();

        if (balance < 0) {
            System.out.println("Invalid Balance!");
            return;
        }

        accounts.add(new BankAccount(number, name, balance));

        System.out.println("Account Created Successfully!");
    }

    static void deposit() {

        System.out.print("Enter Account Number: ");
        int number = sc.nextInt();

        for (BankAccount a : accounts) {

            if (a.accountNumber == number) {

                System.out.print("Enter Deposit Amount: ");
                double amount = sc.nextDouble();

                if (amount > 0) {
                    a.balance += amount;
                    System.out.println("Money Deposited Successfully!");
                } else {
                    System.out.println("Invalid Amount!");
                }

                return;
            }
        }

        System.out.println("Account Not Found!");
    }

    static void withdraw() {

        System.out.print("Enter Account Number: ");
        int number = sc.nextInt();

        for (BankAccount a : accounts) {

            if (a.accountNumber == number) {

                System.out.print("Enter Withdraw Amount: ");
                double amount = sc.nextDouble();

                if (amount > 0 && amount <= a.balance) {
                    a.balance -= amount;
                    System.out.println("Money Withdrawn Successfully!");
                } else {
                    System.out.println("Insufficient Balance or Invalid Amount!");
                }

                return;
            }
        }

        System.out.println("Account Not Found!");
    }

    static void checkBalance() {

        System.out.print("Enter Account Number: ");
        int number = sc.nextInt();

        for (BankAccount a : accounts) {

            if (a.accountNumber == number) {
                System.out.println("Available Balance: Rs. " + a.balance);
                return;
            }
        }

        System.out.println("Account Not Found!");
    }

    static void displayAccounts() {

        if (accounts.isEmpty()) {
            System.out.println("No Accounts Available!");
            return;
        }

        for (BankAccount a : accounts) {
            System.out.println("\n--------------------");
            a.display();
        }
    }
}
