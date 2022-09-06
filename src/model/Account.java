package model;

import java.io.Serializable;

public class Account implements Serializable {
    private String name, password;
    private InformationCustomer informationCustomer;

    public Account() {
    }


    public Account(String name, String password, InformationCustomer informationCustomer) {
        this.name = name;
        this.password = password;
        this.informationCustomer = informationCustomer;
    }

    public Account(InformationCustomer informationCustomer) {
        this.informationCustomer = informationCustomer;
    }

    public Account(String name, String password) {
        this.name = name;
        this.password = password;
    }


    public Account(String name, String password, String nameCustomer, String address, int telephone) {
    }

    public Account(String nameCustomer, String address, int telephone) {

    }

    public String getname() {
        return name;
    }

    public void setname(String name) {
        this.name = name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public InformationCustomer getInformationCustomer() {
        return informationCustomer;
    }

    public void setInformationCustomer(InformationCustomer informationCustomer) {
        this.informationCustomer = informationCustomer;
    }

    @Override
    public String toString() {
        return "Tai Khoan{" +
                "Ten: '" + name + '\'' +
                ", Mat khau: '" + password + '\'' +
                ", Thong tin khach hang: " + informationCustomer +
                '}';
    }
}
