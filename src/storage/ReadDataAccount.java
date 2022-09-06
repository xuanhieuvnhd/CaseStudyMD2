package storage;

import model.Account;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

import static controller.LoginManager.accounts;

public class ReadDataAccount {
    public static ArrayList<Account> readData() {
        File file = new File("Account.txt");
            try {
                ObjectInputStream o = new ObjectInputStream(new FileInputStream(file));
                accounts = (ArrayList<Account>) o.readObject();
                o.close();
            } catch (Exception e) {
                System.out.println();
            }
            return accounts;
    }
}
