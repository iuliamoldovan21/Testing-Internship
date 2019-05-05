package Controller;

import Model.Product;
import Repository.CSVRepository;

import java.io.IOException;
import java.util.ArrayList;

public class Controller {
    private CSVRepository repo;

    public Controller(CSVRepository r) {
        repo = r;
    }

    public void deleteProduct(String name) {
        repo.deleteProduct(name);
    }

    public void addProduct(Product p) {
        repo.addProduct(p);
    }

    public void updateProduct(String p1, Product p2) {
        repo.updateProduct(p1, p2);
    }

    public ArrayList<Product> readFile() throws IOException {
        return repo.readFile();
    }
}
