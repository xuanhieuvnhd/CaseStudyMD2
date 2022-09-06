package controller;

import model.InformationCustomer;
import model.Account;
import views.MenuAdmin;
import views.MenuCustomer;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Pattern;

import static storage.WriteDataAccount.writeData;

public class LoginManager {
    public static ArrayList<Account> accounts = new ArrayList<>();

    public Account creatAccount(Scanner scanner) {
        String name;
        do {
            System.out.print("Nhap ten tai khoan: ");
            name = scanner.nextLine();
            while (true) {
                Pattern p = Pattern.compile("^[a-z0-9._-]{3,15}$");
                if (p.matcher(name).find()) {
                    break;
                } else {
                    System.err.println("Ten dang nhap phai tu 3 den 15 ki tu ban nhe ");
                    System.out.print("Nhap ten tai khoan moi: ");
                    name = scanner.nextLine();
                }
            }
        }
        while (!checkSameAccount(name));
        System.out.print("Nhap mat khau: ");
        String password = scanner.nextLine();
        System.out.print("Ho va ten: ");
        String nameCustomer = scanner.nextLine();
        System.out.print("Dia chi: ");
        String address = scanner.nextLine();
        System.out.print("So dien thoai: ");
        String telephone = scanner.nextLine();
        while (true) {
            Pattern p = Pattern.compile("^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$");
            if (p.matcher(telephone).find()) {
                break;
            } else {
                System.out.println("Chua dung dinh dang so dien thoai, vui long nhap lai: ");
                telephone = scanner.nextLine();
            }
        }
        InformationCustomer information = new InformationCustomer(nameCustomer, address, telephone);
        return new Account(name, password, information);
    }

    public void addAccount() {
        Scanner scanner = new Scanner(System.in);
        Account account = creatAccount(scanner);
        accounts.add(account);
        System.out.println("Dang ki tai khoan thanh cong!");
        System.out.println("_________________________");
        writeData(accounts);
    }

    public boolean checkSameAccount(String userName) {
        String admin = "adm";
        String none = "";
        String name = " ";
        if (userName.equals(name)){
            System.err.println("Chung toi khong ho tro ten nay");
            return false;
        }
        if (userName.equals(none)) {
            System.out.println("Khong duoc de trong ten");
            return false;
        }
        if (userName.equals(admin)) {
            System.out.println("Trung ten voi tai khoan quan ly roi ban oi");
            return false;
        }
        for (Account account : accounts) {
            if (account.getname().equals(userName)) {
                System.out.println("Tai khoan da ton tai");
                return false;
            }
        }
        return true;
    }


    public void login(Scanner scanner) {
        int count = 0;
        do {
            System.out.print("Tai khoan: ");
            String Username = scanner.nextLine();
            System.out.print("Mat khau: ");
            String password = scanner.nextLine();
            if (checkAdmin(Username, password)) {
                MenuAdmin.menu();
            } else {
                checkAccount(Username, password);
            }
            count++;
        }
        while (count < 3);
        System.err.println("Nhap sai qua nhieu, vui long chay lai chuong trinh");
        System.exit(0);
    }

    public boolean checkAdmin(String account, String password) {

        if (account.equals("adm") && password.equals("adm")) {
            return true;
        } else {
            return false;
        }
    }
    public static void checkAccount(String userName, String password) {
        boolean check = false;
        for (Account a : accounts) {
            if (a.getname().equals(userName) && a.getPassword().equals(password)) {
                check = true;
                System.out.println("Dang nhap thanh cong");
                MenuCustomer menuCustomer = new MenuCustomer();
                menuCustomer.menu();
            }
        }
        if (!check) {
            System.err.println("Sai ten tai khoan hoac mat khau!");
        }
    }

    public static void displayInformationCustomer() {
        System.out.printf("%-3s%25s%20s%30s", "Ten dang nhap", "Ten khach hang", "Dia chi", "So dien thoai");
        System.out.println();
        for (int i = 0; i < accounts.size(); i++) {
            System.out.println();
            System.out.printf("%-22s%-25s%-30s%s", accounts.get(i).getname(), accounts.get(i).getInformationCustomer().getNameCustomer(), accounts.get(i).getInformationCustomer().getAddress(), accounts.get(i).getInformationCustomer().getTelephone());
            System.out.println();
        }
    }

    public static void deleteAccount(Scanner scanner) {
        System.out.print("Ten tai khoan muon xoa: ");
        String name = scanner.nextLine();
        for (int i = 0; i < accounts.size(); i++) {
            if (accounts.get(i).getname().equals(name)) {
                accounts.remove(i);
            }
        }
        writeData(accounts);
    }
    public void changePassword(Scanner scanner) {
        System.out.print("Nhap mat khau hien tai: ");
        String password = scanner.nextLine();
        for (int i = 0 ; i < accounts.size() ; i++){
            if (accounts.get(i).getPassword().equals(password)){
                System.out.print("Nhap mat khau moi: ");
                String password1 = scanner.nextLine();
                accounts.get(i).setPassword(password1);
                System.out.println("Thay doi mat khau thanh cong !");
                writeData(accounts);
            }
        }
    }

//    public static void writeDocuments(ArrayList<Account> arrayListAccounts) {
//        File file = new File("Account.txt");
//        try {
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
//            objectOutputStream.writeObject(arrayListAccounts);
//            objectOutputStream.close();
//        } catch (Exception e) {
//            System.out.println(".");
//        }
//    }
//
//    public static void readDocuments() {
//        File file = new File("Account.txt");
//        try {
//            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(file));
//            accounts = (ArrayList<Account>) objectInputStream.readObject();
//            objectInputStream.close();
//        } catch (Exception e) {
//            System.out.println();
//        }
//    }
}
