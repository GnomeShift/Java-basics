import java.util.*;

public class Order {
    private Customer customer;
    private List<Product3> products;
    private int totalPrice;

    public Order(Customer customer) {
        this.customer = customer;
        this.products = new ArrayList<>();
        this.totalPrice = 0;
    }

    public void addProduct(Product3 product) {
        products.add(product);
        totalPrice += product.getPrice();
    }

    public Customer getCustomer() {
        return customer;
    }

    public List<Product3> getProducts() {
        return products;
    }

    public int getTotalPrice() {
        return totalPrice;
    }
}

class Customer {
    private String name;

    public Customer(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

class Product3 {
    private String name;
    private int price;

    public Product3(String name, int price) {
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }
}

class Main15 {
    public static void main(String[] args) {
        Customer customer = new Customer("Иван Иванов");
        Order order = new Order(customer);

        Product3 product1 = new Product3("Телефон", 70000);
        Product3 product2 = new Product3("Наушники", 15000);

        order.addProduct(product1);
        order.addProduct(product2);

        System.out.println("Заказ клиента: " + order.getCustomer().getName());
        System.out.println("Товары в заказе:");
        for (Product3 product : order.getProducts()) {
            System.out.println(product.getName() + " - " + product.getPrice() + " руб.");
        }
        System.out.println("Общая стоимость заказа: " + order.getTotalPrice() + " руб.");
    }
}