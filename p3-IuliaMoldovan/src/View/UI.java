package View;

import Controller.Controller;
import Model.Product;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class UI {
    private Controller ctrl;

    public UI(Controller ctrl) {
        this.ctrl = ctrl;
    }

    private void printMenu() {
        System.out.println("1. Add a product");
        System.out.println("2. Print all products");
        System.out.println("3. Delete a product");
        System.out.println("4. Update a product");
        System.out.println("0.Exit");
    }

    private static Product readProduct() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Insert the name of the new product");
        String name = scanner.next();
        System.out.println("Insert the price");
        int price = scanner.nextInt();
        System.out.println("Insert the quantity");
        int quantity = scanner.nextInt();
        return new Product(name, price, quantity);
    }

    private static String readName() {
        Scanner scn = new Scanner(System.in);
        System.out.println("Insert the name of the product you want to delete/update");
        return scn.next();
    }

    private void printFile() throws IOException {
        ArrayList<Product> products = ctrl.readFile();
        for (int i = 0; i < products.size(); i++) {
            System.out.println(products.get(i).getProductName() + " " + products.get(i).getPrice() + " " + products.get(i).getQuantity() + "\n");
        }
    }

    public void start() {
        try {
            while (true) {
                printMenu();
                Scanner scanner = new Scanner(System.in);
                int option = scanner.nextInt();
                if (option == 1) {
                    Product product = readProduct();
                    ctrl.addProduct(product);
                }
                if (option == 2)
                    printFile();
                if (option == 3) {
                    String name = readName();
                    ctrl.deleteProduct(name);
                }
                if (option == 4) {
                    String p1 = readName();
                    Product p2 = readProduct();
                    ctrl.updateProduct(p1, p2);
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
