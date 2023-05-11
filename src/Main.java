public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(500, "Peter Parker");
        BankAccount account2 = new BankAccount(5000, "Gwen Stacy");
        BankAccount account3 = new BankAccount(300, "Doctor Octopus");

        account1.deposit(100);
        account2.withdraw(100);
        account3.deposit(100);

        account1.printAccountDetails();
        account2.printAccountDetails();
        account3.printAccountDetails();
    }
}
