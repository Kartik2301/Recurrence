package LLDQuestions.InventoryManagementSystem.User;

import LLDQuestions.InventoryManagementSystem.Location.Location;
import LLDQuestions.InventoryManagementSystem.User.Cart.Cart;

public class User {
    private String userName;
    private String email;
    private String contact;
    private Cart cart;
    private Location address;

    public User(String userName, String email, String contact, Location address) {
        this.userName = userName;
        this.email = email;
        this.contact = contact;
        this.cart = new Cart();
        this.address = address;
    }

    public String getUserName() {
        return userName;
    }
    public String getEmail() {
        return email;
    }
    public String getContact() {
        return contact;
    }
    public Cart getCart() {
        return cart;
    }
    public Location getAddress() {
        return address;
    }
    
}
