package views;

import controller.LoginManager;

import java.util.Scanner;
import storage.ReadDataAccount;
import storage.ReadDataProduct;

public class MenuLogin {

    public static void loginMenu() {
        Scanner scanner = new Scanner(System.in);
        LoginManager loginManager = new LoginManager();
        ReadDataAccount.readData();
        ReadDataProduct.readData();
        int choice = -1;
        do {
            System.out.println("*****************************");
            System.out.println("---------------->Menu<----------------");
            System.out.println("**          1. Dang nhap              **");
            System.out.println("**          2. Dang ky                  **");
            System.out.println("------------------------------------------");
            System.out.println("**          0. Thoat he thong        **");
            System.out.println("*****************************");
            System.out.print("------ > Moi chon: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Vui long nhap dung!");
            }

            switch (choice) {
                case 1 -> loginManager.login(scanner);
                case 2 -> loginManager.addAccount();
                case 0 -> System.exit(0);
            }
        } while (true);
    }
}