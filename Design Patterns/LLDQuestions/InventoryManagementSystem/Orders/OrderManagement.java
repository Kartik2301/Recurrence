package LLDQuestions.InventoryManagementSystem.Orders;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import LLDQuestions.InventoryManagementSystem.Location.Location;
import LLDQuestions.InventoryManagementSystem.Products.Product;
import LLDQuestions.InventoryManagementSystem.User.User;

public class OrderManagement {
    private List<Order> orders;

    public OrderManagement() {
        this.orders = new ArrayList<>();
    }

    public Order createOrder(User user, Location address, Map<Product, Integer> productsOrdered, int cost) {
        Order order = new Order(user, 0, address, productsOrdered, new Invoice(cost));

        orders.add(order);
        System.out.println(order);

        return order;
    }
}
