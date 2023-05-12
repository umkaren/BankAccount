import java.util.Scanner;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<BankAccount> accounts = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        BankAccount currentAccount = null;

        //creates three instances from first Bank account exercise. Modified to complete Bank Account Continuation. See previous commit for Part 1.
        accounts.add(new BankAccount(500, "Peter Parker", 001));
        accounts.add(new BankAccount(5000, "Gwen Stacy", 002));
        accounts.add(new BankAccount(300, "Doctor Octopus", 003));

        //deposits and withdrawals from part 1
        accounts.get(0).deposit(100);
        accounts.get(1).withdraw(100);
        accounts.get(2).deposit(100);

        //adding user input from part 2: bank account
        System.out.println("Hello world! Welcome to the Bank of Karen!");
        System.out.println("Are you an existing customer?");
        System.out.println("1. Yes");
        System.out.println("2. No");

        String yesOrNo = scanner.nextLine();

        //if users says they have an account
        if (yesOrNo.equalsIgnoreCase("yes")) {
            System.out.println("What is the name for the account?");
            String accountName = scanner.nextLine();

            boolean accountFound = false;
            for (BankAccount account : accounts) {
                if (account.getAccountHolder().equalsIgnoreCase(accountName)) {
                    currentAccount = account;
                    accountFound = true;
                    break;
                }
            }
            if (!accountFound) {
                System.out.println("Account not found.");
            } else {
                System.out.println("Welcome back, " + currentAccount.getAccountHolder() + "!");
                mainMenu(currentAccount, accounts);
            }
        } else if (yesOrNo.equalsIgnoreCase("no")) {
            //ask user for input to create new account
            System.out.println("Let's make a new account!");
            BankAccount newAccount = new BankAccount();
            //adds new account to accounts ArrayList
            accounts.add(newAccount);
            System.out.println("Your account has been created");
            currentAccount = newAccount;
            mainMenu(currentAccount, accounts);
        }
    }

    //adding main menu
    public static void mainMenu(BankAccount currentAccount, ArrayList<BankAccount> accounts) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("This is the main menu. What would you like to do today?");
        System.out.println("1. To check account balance");
        System.out.println("2. To make a withdrawal");
        System.out.println("3. To make a deposit");
        System.out.println("4. To make a transfer to another account");
        System.out.println("0. To exit");

        int choice = scanner.nextInt();
        //set amount in case of deposit/withdrawal/transfer
        double amount;
        int accountNumber;

        switch (choice) {
            case 0:
                System.out.println("Thanks for visiting! Goodbye!");
                break;
            case 1:
                System.out.println("Your balance is $" + currentAccount.getAccountBalance());
                break;
            case 2:
                System.out.println("How much would you like to withdraw?");
                amount = scanner.nextDouble();
                currentAccount.withdraw(amount);
                System.out.println("Withdrawal completed. Your account balance is now $" + currentAccount.getAccountBalance());
                break;
            case 3:
                System.out.println("How much would you like to deposit?");
                amount = scanner.nextDouble();
                currentAccount.deposit(amount);
                System.out.println("Deposit completed. Your account balance is now $" + currentAccount.getAccountBalance());
                break;
            case 4:
                System.out.println("Please enter the account number to transfer to");
                accountNumber = scanner.nextInt();
                BankAccount recipient = null;

                for (BankAccount account : accounts) {
                    if (account.getAccountNumber() == accountNumber) {
                        recipient = account;
                        break;
                    }
                }
                if (recipient != null) {
                    System.out.println("Please enter the amount to transfer");
                    amount = scanner.nextDouble();
                    currentAccount.transfer(accounts, recipient, amount);
                } else {
                    System.out.println("Recipient account not found.");
                }
                break;
            default:
                System.out.println("Invalid choice. Please input an option from 0-4.");
        }
    }
}
