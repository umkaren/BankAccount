import java.util.ArrayList;
import java.util.Scanner;
class BankAccount {
    private double accountBalance;
    private String accountHolder;
    private int accountNumber;

    //first constructor that takes three parameters
    public BankAccount(double accountBalance, String accountHolder, int accountNumber) {
        this.accountBalance = accountBalance;
        this.accountHolder = accountHolder;
        this.accountNumber = accountNumber;
    }

    //second constructor that takes no parameters
    public BankAccount() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("What is the name for the account?");
        this.accountHolder = scanner.nextLine();
        System.out.println("What is the beginning balance for the account?");
        this.accountBalance = scanner.nextDouble();
    }
    public void deposit(double deposit) {
        accountBalance += deposit;
    }
    public void withdraw(double withdraw) {
        accountBalance -= withdraw;
    }
    public void transfer(ArrayList<BankAccount> accounts,BankAccount recipient, double amount) {
        boolean accountFound = false;
        for (BankAccount account : accounts) {
            if (account.getAccountNumber() == accountNumber) {
                this.withdraw(amount);
                recipient.deposit(amount);
                accountFound = true;
                break;
            }
        }
        if (!accountFound) {
            System.out.println("Account doesn't exist. Transfer failed.");
        } else {
            System.out.println("Your account balance is now $" + this.getAccountBalance());
            System.out.println(recipient.getAccountHolder() + "'s account balance is $" + recipient.getAccountBalance());
        }
    }
    //this was used in part 1 but no longer used in part 2. Refer to previous commit to see usage.
    public void printAccountDetails() {
        System.out.println(accountHolder + "'s account balance is: $" + accountBalance);
    }

    //part 2 Bank Account
    public String getAccountHolder() {
        return accountHolder;
    }
    public double getAccountBalance() {
        return accountBalance;
    }
    public int getAccountNumber() {
        return accountNumber;
    }
}
