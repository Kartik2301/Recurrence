package LLDQuestions.InventoryManagementSystem.Orders;

import java.sql.Timestamp;
import java.util.Map;

import LLDQuestions.InventoryManagementSystem.Location.Location;
import LLDQuestions.InventoryManagementSystem.Products.Product;
import LLDQuestions.InventoryManagementSystem.User.User;

public class Order {
    private User user;
    private int orderID;
    private Timestamp orderedOn;
    private Location address;
    private Map<Product, Integer> productsOrdered;
    private OrderStatus orderStatus;
    private Invoice invoice;
    private int orderCost;

    public Order(User user, int orderID, Location address, Map<Product, Integer> productsOrdered, Invoice invoice) {
        this.user = user;
        this.orderID = orderID;
        this.address = address;
        this.productsOrdered = productsOrdered;
        this.orderedOn = new Timestamp(System.currentTimeMillis());
        this.orderStatus = OrderStatus.ONGOING;
        this.invoice = invoice;
    }

    public User getUser() {
        return user;
    }
    public void setUser(User user) {
        this.user = user;
    }
    public int getOrderID() {
        return orderID;
    }
    public void setOrderID(int orderID) {
        this.orderID = orderID;
    }
    public Timestamp getOrderedOn() {
        return orderedOn;
    }
    public void setOrderedOn(Timestamp orderedOn) {
        this.orderedOn = orderedOn;
    }
    public Location getAddress() {
        return address;
    }
    public void setAddress(Location address) {
        this.address = address;
    }
    public Map<Product, Integer> getProductsOrdered() {
        return productsOrdered;
    }
    public void setProductsOrdered(Map<Product, Integer> productsOrdered) {
        this.productsOrdered = productsOrdered;
    }
    public OrderStatus getOrderStatus() {
        return orderStatus;
    }
    public void setOrderStatus(OrderStatus orderStatus) {
        this.orderStatus = orderStatus;
    }
    public Invoice getInvoice() {
        return invoice;
    }
    public int getOrderCost() {
        return orderCost;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for(Map.Entry<Product, Integer> entry: productsOrdered.entrySet()) {
            String productLine = "\n" + entry.getKey().getProductName() + " - " + entry.getValue();
            sb.append(productLine);
        }
        sb.append("\nAmount to be paid: " + invoice.getAmountPayable());
        sb.append("\nOrdered at: " + orderedOn);
        return sb.toString();
    }
    
}
