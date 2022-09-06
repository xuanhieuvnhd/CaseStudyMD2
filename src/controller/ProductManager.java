package controller;

import model.Brand;
import model.Product;
import views.MenuCustomer;

import java.io.*;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;

import static storage.WriteDataProduct.writeData;

public class ProductManager implements Serializable {

    public ProductManager() {
        writeData(products);
    }
    public static ArrayList<Product> products = new ArrayList<>();

    public Product createProduct(Scanner scanner) {
        Brand brand = createBrand(scanner);
        System.out.print("Ten san pham: ");
        String nameProduct = scanner.nextLine();
        System.out.print("Gia san pham: ");
        int price = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhap so luong: ");
        int amount = Integer.parseInt(scanner.nextLine());
        System.out.print("Nhap kich co: ");
        String size = scanner.nextLine();
        return new Product(nameProduct, price, amount, size, brand);
    }

    public Brand createBrand(Scanner scanner) {
        System.out.print("Ten hang: ");
        String brand = scanner.nextLine();
        return new Brand(brand);
    }

    public void addProduct(Scanner scanner) {
        Product product = createProduct(scanner);
        products.add(product);
        writeData(products);
    }

    public void displayProduct() {
        int total = 0;
        System.out.printf("%5s%15s%24s%18s%20s%20s\n", "Ma so", "Hang", "Ten san pham", "Gia", "So luong", "Kich co");
        for (int i = 0; i < products.size(); i++) {
            System.out.println();
            System.out.printf("%-16s%-16s%-27s%s%-17s%-21s%s\n", products.get(i).getId(), products.get(i).getBrand().getName(), products.get(i).getName(), products.get(i).getPrice(),"$", products.get(i).getAmount(), products.get(i).getSize());
            System.out.println();
        }
        for (Product product : products) {
            total += product.getAmount();
        }
        System.out.println("Tong so luong hang trong kho: " + total);
    }

    public void findById(Scanner scanner) {
        System.out.print("Nhap vao ID san pham can tim: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product b : products) {
            if (b.getId() == id) {
                System.out.printf("%5s%15s%24s%18s%20s%20s\n", "Ma so", "Hang", "Ten san pham", "Gia", "So luong", "Kich co");
                System.out.println();
                System.out.printf("%-16s%-16s%-27s%s%-17s%-21s%s\n", b.getId(), b.getBrand().getName(), b.getName(),b.getPrice(),"$",  b.getAmount(), b.getSize());
                System.out.println();
            }
        }
    }

    public void updateAmount() {
        for (int i = 0; i < CartManager.carts.size(); i++) {
            for (Product product : products) {
                if (CartManager.carts.get(i).getId() == product.getId()) {
                    product.setAmount(product.getAmount() - CartManager.carts.get(i).getCount());
                }
            }
        }
        writeData(products);
    }

    public void findByName(Scanner scanner) {
        System.out.print("Nhap ten san pham can tim: ");
        String search = scanner.nextLine();
        System.out.printf("%5s%15s%24s%18s%20s%20s\n", "Ma so", "Hang", "Ten san pham", "Gia", "So luong", "Kich co");
        for (Product b : products) {
            if (b.getName().toUpperCase().contains(search.toUpperCase())) {
                System.out.println();
                System.out.printf("%-16s%-16s%-27s%s%-17s%-21s%s\n", b.getId(), b.getBrand().getName(), b.getName(), b.getPrice(),"$", b.getAmount(), b.getSize());
                System.out.println();
            }
        }
    }

    public void findByBrand(Scanner scanner){
        System.out.print("Nhap hang can tim: ");
        String search = scanner.nextLine();
        System.out.printf("%5s%15s%24s%18s%20s%20s\n", "Ma so", "Hang", "Ten san pham", "Gia", "So luong", "Kich co");
        for (Product b : products) {
            if (b.getBrand().getName().equals(search)) {
                System.out.println();
                System.out.printf("%-16s%-16s%-27s%s%-17s%-21s%s\n", b.getId(), b.getBrand().getName(), b.getName(), b.getPrice(),"$", b.getAmount(), b.getSize());
                System.out.println();
            }
        }
    }
    public void deleteProduct(Scanner scanner) {
        System.out.print("Nhap vao ID san pham muon xoa: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (Product product : products) {
            if (product.getId() == id) {
                products.remove(product);
                writeData(products);
            }
        }
    }


    public void editBrandName(Scanner scanner, int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == (id)) {
                System.out.print("Nhap ten hang can sua: ");
                String name = scanner.nextLine();
                products.get(i).getBrand().setName(name);
                writeData(products);
            }
        }
    }

    public void editProduceName(Scanner scanner, int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == (id)) {
                System.out.print("Nhap ten san pham can sua: ");
                String name = scanner.nextLine();
                products.get(i).setName(name);
                writeData(products);
            }
        }
    }

    public void editProducePrice(Scanner scanner, int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == (id)) {
                System.out.print("Nhap ten gia san pham muon sua: ");
                int price = Integer.parseInt(scanner.nextLine());
                products.get(i).setPrice(price);
                writeData(products);
            }
        }
    }

    public void editProduceAmount(Scanner scanner, int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == (id)) {
                System.out.print("Nhap so luong san pham muon sua: ");
                int amount = Integer.parseInt(scanner.nextLine());
                products.get(i).setAmount(amount);
                writeData(products);
            }
        }
    }

    public void editProduceSize(Scanner scanner, int id) {
        for (int i = 0; i < products.size(); i++) {
            if (products.get(i).getId() == (id)) {
                System.out.print("Nhap kich co san pham can sua: ");
                String size = scanner.nextLine();
                products.get(i).setSize(size);
                writeData(products);
            }
        }
    }
    public void sortProductsByPriceAscending() {
        Comparator<Product> comparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getPrice() - o2.getPrice());
            }
        };
        products.sort(comparator);
        System.out.println("Danh sach san pham da duoc xep theo gia tang dan: ");
        displayProduct();
    }
    public void sortProductById(){
        Comparator<Product> comparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o1.getId() - o2.getId());
            }
        };
        products.sort(comparator);
        System.out.println("Danh sach san pham da duoc xep theo ma so tang dan: ");
        displayProduct();
    }

    public void sortProductByPriceDescending() {
        Comparator<Product> comparator = new Comparator<Product>() {
            @Override
            public int compare(Product o1, Product o2) {
                return (int) (o2.getPrice() - o1.getPrice());
            }
        };
        products.sort(comparator);
        System.out.println("Danh sach san pham da duoc xep theo gia giam dan: ");
        displayProduct();
    }

    public void findProductHighestPrice() {
        double max = 0;
        int product = 0;
        for (int i = 0; i < products.size(); i++) {
            if (max < products.get(i).getPrice()) {
                max = products.get(i).getPrice();
                product = i;
            }
        }
        System.out.println("San pham co gia cao nhat trong he thong la: ");
        System.out.println(products.get(product));
    }

    public void sortProductByPrice(Scanner scanner) {
        int choose = -1;
        do {
            System.out.println("1. Sap xep theo gia san pham (tang dan)");
            System.out.println("2. Sap xep theo gia san pham (giam dan)");
            System.out.println("3. Sap xep san pham theo ma so (tang dan) ");
            System.out.println("4. San pham co gia cao nhat trong cua hang");
            System.out.println("0. Quay ve Menu");
            try {
                choose = Integer.parseInt(scanner.nextLine());
            } catch (Exception e) {
                System.err.println("Chuc nang khong ton tai ! vui long chon lai: ");
            }
            switch (choose) {
                case 1 -> sortProductsByPriceAscending();
                case 2 -> sortProductByPriceDescending();
                case 3 -> sortProductById();
                case 4 -> findProductHighestPrice();
                case 0 -> MenuCustomer.menu();
            }
        }
        while (choose != 0);
    }


//    public void  writeDocuments(ArrayList<Product> arrayListProduct) {
//        File file = new File("Product.txt");
//        try {
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
//            objectOutputStream.writeObject(arrayListProduct);
//            objectOutputStream.close();
//        } catch (Exception e) {
//            System.out.println(".");
//        }
//    }

//    public static void readDocuments() {
//        File file = new File("Product.txt");
//        try {
//            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
//            products = (ArrayList<Product>) objectInputStream.readObject();
//            objectInputStream.close();
//        } catch (Exception e) {
//            System.out.println();
//        }
//    }
}
