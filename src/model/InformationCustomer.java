package model;

import java.io.Serializable;

public class InformationCustomer implements Serializable {
    private String nameCustomer;
    private String address;
    private String telephone;

    public InformationCustomer(String nameCustomer, String address, String telephone) {
        this.nameCustomer = nameCustomer;
        this.address = address;
        this.telephone = telephone;
    }

    public String getNameCustomer() {
        return nameCustomer;
    }

    public void setNameCustomer(String nameCustomer) {
        this.nameCustomer = nameCustomer;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Thong tin khach hang{" +
                "Ten khach hang: '" + nameCustomer + '\'' +
                ", Dia chi: " + address + '\'' +
                ", So dien thoai: " + telephone +
                '}';
    }
}
