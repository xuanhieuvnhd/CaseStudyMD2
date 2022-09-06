package storage;

import model.Product;

import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class WriteDataProduct {
    public static void writeData(ArrayList<Product> products) {
        File file = new File("Product.txt");
        try {
            if (!file.exists()) {
                file.createNewFile();
            }
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(file));
            objectOutputStream.writeObject(products);
            objectOutputStream.close();
        } catch (Exception e) {
            System.out.println();
        }
    }
}
