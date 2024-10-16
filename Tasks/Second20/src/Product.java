import java.util.*;

public class Product {
    String name;
    int price;
    int quantity;

    Product(String name, int price, int quantity) {
        this.name = name;
        this.price = price;
        this.quantity = quantity;
    }

    public String getProductName() {
        return name;
    }

    public int getProductPrice() {
        return price;
    }

    public int getProductQuantity() {
        return quantity;
    }
}

class Shop {
    List<Product> products;

    Shop() {
        this.products = new ArrayList<>();
    }

    public void addProduct(Product product) {
        this.products.add(product);
    }

    public void removeProduct(Product product) {
        this.products.remove(product);
    }

    public void findProduct(String name) {
        for (Product product : products) {
            if (product.name.equals(name)) {
                System.out.println("Товар: " + product.getProductName() + " со стоимостью: " + product.getProductPrice() + " и кол-вом: " + product.getProductQuantity());
            }
        }
    }
}

class Main8 {
    public static void main(String[] args) {
        Shop shop = new Shop();

        Product apple = new Product("Яблоко", 150, 10);
        Product pear = new Product("Груша", 160, 20);

        shop.addProduct(apple);
        shop.addProduct(pear);

        shop.findProduct("Яблоко");
        shop.findProduct("Груша");
    }
}
