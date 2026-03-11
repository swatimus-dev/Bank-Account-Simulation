import java.util.ArrayList;

public class BankService {

    private ArrayList<BankAccount> accounts;

    public BankService() {
        accounts = FileManager.loadAccounts();
    }

    public void save() {
        FileManager.saveAccounts(accounts);
    }

    public void createAccount(int accNo, String name) {
        BankAccount acc = new BankAccount(accNo, name);
        accounts.add(acc);
        save();
        System.out.println("Account created successfully!");
    }

    public BankAccount findAccount(int accNo) {
        for (BankAccount acc : accounts) {
            if (acc.getAccountNumber() == accNo) {
                return acc;
            }
        }
        return null;
    }

    public void deposit(int accNo, double amount) {
        BankAccount acc = findAccount(accNo);

        if (acc != null) {
            acc.deposit(amount);
            save();
        } else {
            System.out.println("Account not found!");
        }
    }

    public void withdraw(int accNo, double amount) {
        BankAccount acc = findAccount(accNo);

        if (acc != null) {
            acc.withdraw(amount);
            save();
        } else {
            System.out.println("Account not found!");
        }
    }

    public void checkBalance(int accNo) {
        BankAccount acc = findAccount(accNo);

        if (acc != null) {
            System.out.println("Balance: ₹" + acc.getBalance());
        } else {
            System.out.println("Account not found!");
        }
    }

    public void showTransactions(int accNo) {
        BankAccount acc = findAccount(accNo);

        if (acc != null) {
            acc.showTransactions();
        } else {
            System.out.println("Account not found!");
        }
    }
}