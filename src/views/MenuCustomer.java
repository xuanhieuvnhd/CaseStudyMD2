package views;

import controller.CartManager;
import controller.LoginManager;
import controller.ProductManager;
import storage.product.ReadData;

import java.util.Scanner;

public class MenuCustomer {
    public static void menu() {
        Scanner scanner = new Scanner(System.in);
        ProductManager productManager = new ProductManager();
        CartManager cartManager = new CartManager();
        LoginManager loginManager = new LoginManager();
        ReadData.readData();
        storage.account.ReadData.readData();
        int choice;
        do {
            System.out.println("______ Menu Khach Hang _______");
            System.out.println("1. Cac san pham cua shop");
            System.out.println("2. Tim kiem san pham theo ten");
            System.out.println("3. Mua sam");
            System.out.println("4. Hien thi gio hang");
            System.out.println("5. Xoa san pham trong gio hang");
            System.out.println("6. Thanh toan");
            System.out.println("7. Dong gop y kien cho shop");
            System.out.println("8. Doi mat khau");
            System.out.println("9. Sap xep cac san pham theo gia");
            System.out.println("0. Dang xuat");
            System.out.println("______________________________");
            System.out.print("Nhap lua chon: ");
            choice = Integer.parseInt(scanner.nextLine());
            switch (choice) {
                case 1 -> productManager.displayProduct();
                case 2 -> productManager.findByName(scanner);
                case 3 -> cartManager.addCart();
                case 4 -> cartManager.displayCart();
                case 5 -> cartManager.deleteProductInCart();
                case 6 -> cartManager.pay();
                case 7 -> cartManager.feedback(scanner);
                case 8 -> loginManager.changePassword(scanner);
                case 9 -> productManager.sortProductByPrice(scanner);
                case 0 -> MenuLogin.loginMenu();
            }
        } while (choice != 0);
    }
}
