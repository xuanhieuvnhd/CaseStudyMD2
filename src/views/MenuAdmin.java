package views;

import controller.CartManager;
import controller.LoginManager;
import controller.ProductManager;
import storage.product.ReadData;

import java.io.Serializable;
import java.util.Scanner;

public class MenuAdmin implements Serializable {
    public static void menu() {
        ProductManager productManage = new ProductManager();
        CartManager cartManager = new CartManager();
        Scanner scanner = new Scanner(System.in);
        storage.account.ReadData.readData();
        ReadData.readData();
        int choice = -1;
        do {
            System.out.println("-------------------Menu Admin-------------------");
            System.out.println("1. Them san pham");
            System.out.println("2. Sua san pham");
            System.out.println("3. Xoa san pham theo ID");
            System.out.println("4. Tim san pham theo ID");
            System.out.println("5. Tim san pham theo ten");
            System.out.println("6. Tim san pham theo ten hang");
            System.out.println("7. Hien thi toan bo san pham cua shop");
            System.out.println("8. Hien thi cac tai khoan da dang ki");
            System.out.println("9. Xoa tai khoan khach");
            System.out.println("10. Phan hoi cua khach hang");
            System.out.println("0. Dang xuat");
            System.out.println("_____________________________________");
            System.out.print("Nhap lua chon: ");
            try {
                choice = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.out.println("Vui long nhap dung!");
            }

            switch (choice) {
                case 1 -> productManage.addProduct(scanner);
                case 2 -> {
                    System.out.print("Nhap vao ID san pham muon sua: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("------ Update san pham ------");
                    System.out.println("1. Sua ten hang");
                    System.out.println("2. Sua ten san pham");
                    System.out.println("3. Sua gia san pham");
                    System.out.println("4. Sua so luong san pham");
                    System.out.println("5. Sua kich co san pham");
                    System.out.println("_________________________");
                    System.out.print("Nhap lua chon cua ban: ");
                    int choice1 = Integer.parseInt(scanner.nextLine());
                    switch (choice1) {
                        case 1 -> productManage.editBrandName(scanner, id);
                        case 2 -> productManage.editProduceName(scanner, id);
                        case 3 -> productManage.editProducePrice(scanner, id);
                        case 4 -> productManage.editProduceAmount(scanner, id);
                        case 5 -> productManage.editProduceSize(scanner, id);
                    }
                }
                case 3 -> productManage.deleteProduct(scanner);
                case 4 -> productManage.findById(scanner);
                case 5 -> productManage.findByName(scanner);
                case 6 -> productManage.findByBrand(scanner);
                case 7 -> {
                    productManage.displayProduct();
                    productManage.updateAmount();
                }
                case 8 -> LoginManager.displayInformationCustomer();
                case 9 -> LoginManager.deleteAccount(scanner);
                case 10 -> cartManager.displayFeedback();
                case 0 -> MenuLogin.loginMenu();
            }
        } while (choice != 0);
    }
}
