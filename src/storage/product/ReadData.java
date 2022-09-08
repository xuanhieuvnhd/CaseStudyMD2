package storage.product;
import model.Product;

import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import static controller.ProductManager.products;

public class ReadData {
    public static ArrayList<Product> readData() {
        File file = new File("Product.txt");
        try {
            ObjectInputStream o = new ObjectInputStream(new FileInputStream(file));
            products = (ArrayList<Product>) o.readObject();
            o.close();
        } catch (Exception e) {
            System.out.println();
        }
        return products;
    }
}
