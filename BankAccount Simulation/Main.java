import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        BankService bank = new BankService();

        while (true) {

            System.out.println("\n===== BANK MENU =====");
            System.out.println("1. Create Account");
            System.out.println("2. Deposit");
            System.out.println("3. Withdraw");
            System.out.println("4. Check Balance");
            System.out.println("5. Transaction History");
            System.out.println("6. Exit");

            int choice = sc.nextInt();

            switch (choice) {

                case 1:
                    System.out.print("Account Number: ");
                    int accNo = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Account Holder Name: ");
                    String name = sc.nextLine();

                    bank.createAccount(accNo, name);
                    break;

                case 2:
                    System.out.print("Account Number: ");
                    accNo = sc.nextInt();

                    System.out.print("Deposit Amount: ");
                    double deposit = sc.nextDouble();

                    bank.deposit(accNo, deposit);
                    break;

                case 3:
                    System.out.print("Account Number: ");
                    accNo = sc.nextInt();

                    System.out.print("Withdraw Amount: ");
                    double withdraw = sc.nextDouble();

                    bank.withdraw(accNo, withdraw);
                    break;

                case 4:
                    System.out.print("Account Number: ");
                    accNo = sc.nextInt();

                    bank.checkBalance(accNo);
                    break;

                case 5:
                    System.out.print("Account Number: ");
                    accNo = sc.nextInt();

                    bank.showTransactions(accNo);
                    break;

                case 6:
                    System.out.println("Exiting system...");
                    bank.save();
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}