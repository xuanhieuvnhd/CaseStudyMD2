package storage.account;

import model.Account;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class WriteData {
    public static void writeData(ArrayList<Account> accounts) {
        File file = new File("Account.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(accounts);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println();
        }
    }
}
