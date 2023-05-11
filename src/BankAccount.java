public class BankAccount {
    private double accountBalance;
    private String accountHolder;

    public BankAccount(double accountBalance, String accountHolder) {
        this.accountBalance = accountBalance;
        this.accountHolder = accountHolder;
    }
    public void deposit(double deposit) {
        accountBalance += deposit;
    }
    public void withdraw(double withdraw) {
        accountBalance -= withdraw;
    }

    public void printAccountDetails() {
        System.out.println(accountHolder + "'s account balance is: $" + accountBalance);
    }
}
