package controller;

import model.Cart;
import model.Product;

import java.util.ArrayList;
import java.util.Scanner;

import static controller.ProductManager.products;

public class CartManager {
    Scanner scanner = new Scanner(System.in);
    ProductManager productManager = new ProductManager();
    public static ArrayList<Cart> carts = new ArrayList<>();
    public static ArrayList<String> feedback = new ArrayList<>();

    public CartManager() {
    }

    public Cart createCart() {
        int id=-1;
        while (id < 0){
            try {
                System.out.print("Nhap ma san pham can mua: ");
                id = scanner.nextInt();
                for (Cart cart : carts) {
                    if (cart.getProduct().getId() == id) {
                        System.out.println("Da co trong gio hang");
                        id = -1;
                    }
                }
            }catch (Exception e){
                System.out.println("Ban dang nhap chu");
                scanner.nextLine();
                id = -1;
            }
        }

        Product product = getProductByID(id);
        System.out.print("Nhap so luong can mua: ");
        int newAmount = scanner.nextInt();
        for (Cart cart : carts) {
            if (cart.getProduct().getId() == id) {
                cart.getProduct().setAmount(cart.getProduct().getAmount() + newAmount);
                break;
            }
        }
        for (Product product1 : products) {
            if (newAmount < 0) {
                System.err.println("Vui long nhap so luong can mua");
                System.out.println();
                break;
            }
            if (newAmount > product1.getAmount()) {
                System.out.println("Trong kho con " + product1.getAmount() + " ma ban chon " + newAmount + " thi khong du dap ung!!");
                System.out.println();
                break;
            }
        }

        int totalPrice = newAmount * product.getPrice();
        return new Cart(newAmount, product, totalPrice);
    }


    public Product getProductByID(int id) {
        for (Product product : products) {
            if (id == product.getId()) {
                return product;
            }
        }
        return null;
    }

    public void addCart() {
        Cart cart = createCart();
        carts.add(cart);
        System.out.println("Them san pham thanh cong");
    }

    public void displayCart() {
        System.out.println("Cac san pham co trong gio hang:");
        System.out.printf("%5s%15s%24s%18s%20s%20s\n", "Ma so", "Hang", "Ten san pham", "Gia", "So luong", "Kich co");
        for (int i = 0; i < carts.size(); i++) {
            System.out.println();
            System.out.printf("%-16s%-16s%-27s%s%-17s%-21s%s\n", carts.get(i).getProduct().getId(),
                    carts.get(i).getProduct().getBrand().getName(), carts.get(i).getProduct().getName(), "$",
                    carts.get(i).getProduct().getPrice(), carts.get(i).getCount(), carts.get(i).getProduct().getSize());
            System.out.println();
        }

    }

    public void pay() {
        int sum = 0;
        for (Cart a : carts) {
            sum += a.getTotalPrice();
        }
        System.out.println("Thanh toan thanh cong!");
        System.out.printf("%s%s%s", "Tong so tien cua quy khach la: ", sum +"$","\n");
        productManager.updateAmount();
        carts.clear();
    }

    public void deleteProductInCart() {
        System.out.println("Nhap ma san pham can xoa: ");
        int id;
        id = scanner.nextInt();
        for (int i = 0; i < carts.size(); i++) {
            if (carts.get(i).getProduct().getId() == id) {
                carts.remove(i);
                System.out.println("Xoa san pham thanh cong");
            }
        }
    }
    public void feedback(Scanner scanner){
        System.out.print("Hay gui phan hoi cho chung toi : ");
        String feedback = scanner.nextLine();
        CartManager.feedback.add(feedback);
        System.out.println("Gui phan hoi thanh cong!");
    }
    public void displayFeedback(){
        for (String a: feedback) {
            System.out.println("Noi dung khach phan hoi: " + a);
        }
    }
}

