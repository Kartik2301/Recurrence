package LLDQuestions.InventoryManagementSystem.User.Cart;

import java.util.HashMap;
import java.util.Map;

import LLDQuestions.InventoryManagementSystem.Products.Product;

public class Cart {
    private Map<Product, Integer> products;

    public Cart() {
        products = new HashMap<>();
    }

    public void addProductToCart(Product product, int quantity) {
        products.put(product, products.getOrDefault(product, 0) + quantity);
    }

    public void removeProductFromCart(Product product) {
        int count = products.get(product);
        count--;

        if(count == 0) {
            products.remove(product);
        } else {
            products.put(product, count);
        }
        
    }

    public Map<Product, Integer> getProducts() {
        return products;
    }

    public void setProducts(Map<Product, Integer> products) {
        this.products = products;
    }
}
