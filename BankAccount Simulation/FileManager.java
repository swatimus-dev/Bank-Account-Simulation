import java.io.*;
import java.util.ArrayList;

public class FileManager {

    private static final String FILE_NAME = "accounts.txt";

    public static void saveAccounts(ArrayList<BankAccount> accounts) {

        try {
            ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
            out.writeObject(accounts);
            out.close();
        } catch (IOException e) {
            System.out.println("Error saving accounts.");
        }
    }

    public static ArrayList<BankAccount> loadAccounts() {

        try {
            ObjectInputStream in = new ObjectInputStream(new FileInputStream(FILE_NAME));
            ArrayList<BankAccount> accounts = (ArrayList<BankAccount>) in.readObject();
            in.close();
            return accounts;

        } catch (Exception e) {
            return new ArrayList<>();
        }
    }
}