package Model;

public class Product {
    private String ProductName;
    private Integer Price;
    private Integer Quantity;

    //constructor with parameters
    public Product(String n, Integer p, Integer q) {
        ProductName = n;
        Price = p;
        Quantity = q;
    }

    public Product() {
        ProductName = null;
        Price = 0;
        Quantity = 0;
    }

    public String getProductName() {
        return ProductName;
    }

    public Integer getPrice() {
        return Price;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setProductName(String productName) {
        ProductName = productName;
    }

    public void setPrice(Integer price) {
        Price = price;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public String toString() {
        return ProductName + " " + Price + " " + Quantity;
    }
}
