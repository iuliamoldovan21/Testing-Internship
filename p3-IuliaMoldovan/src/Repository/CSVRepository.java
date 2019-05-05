package Repository;

import Model.Product;

import java.io.*;
import java.util.ArrayList;

public class CSVRepository {
    private String filename;

    public CSVRepository(String filename) {
        this.filename = filename;
    }

    public void addProduct(Product product) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename, true))) {
            writer.append(product.getProductName() + "," + product.getPrice() + "," + product.getQuantity() + System.getProperty("line.separator"));
            System.out.println("Product successfully added!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void deleteProduct(String name) {
        try {
            File inputFile = new File(filename);
            File tempFile = new File("tempFile.txt");
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String currentLine;
            boolean found = false;
            while ((currentLine = reader.readLine()) != null) {
                String[] line = currentLine.split(",");
                if (line[0].equals(name)) {
                    found = true;
                    continue;
                }
                writer.write(currentLine + System.getProperty("line.separator"));
            }
            reader.close();
            writer.close();
            if (!inputFile.delete()) System.out.println("Could not delete file");
            if (!tempFile.renameTo(inputFile)) System.out.println("Could not remove file");
            else if (found) System.out.println("Product successfully deleted!");
            else System.out.println("Product was not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void updateProduct(String product1, Product product2) {
        try {
            File inputFile = new File(filename);
            File tempFile = new File("tempFile.txt");
            BufferedReader reader = new BufferedReader(new FileReader(filename));
            BufferedWriter writer = new BufferedWriter(new FileWriter(tempFile));
            String currentLine;
            boolean found = false;
            while ((currentLine = reader.readLine()) != null) {
                String[] line = currentLine.split(",");
                if (line[0].equals(product1)) {
                    found = true;
                    writer.write(product2.getProductName() + "," + product2.getPrice() + "," + product2.getQuantity() + System.getProperty("line.separator"));
                } else
                    writer.write(currentLine + System.getProperty("line.separator"));
            }
            reader.close();
            writer.close();
            if (!inputFile.delete()) System.out.println("Could not delete file!");
            if (!tempFile.renameTo(inputFile)) System.out.println("Could not remove file!");
            else if (found) System.out.println("Product successfully updated!");
            else System.out.println("Product was not found!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Product> readFile() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(filename));
        ArrayList<Product> products = new ArrayList<>();
        String currentLine;
        while ((currentLine = reader.readLine()) != null) {
            String[] line = currentLine.split(",");
            Product p = new Product();
            p.setProductName(line[0]);
            p.setPrice(Integer.parseInt(line[1]));
            p.setQuantity(Integer.parseInt(line[2]));
            products.add(p);
        }
        return products;
    }
}
