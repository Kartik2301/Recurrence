package LLDQuestions.InventoryManagementSystem;

import java.util.List;
import java.util.Map;

import LLDQuestions.InventoryManagementSystem.Inventory.Inventory;
import LLDQuestions.InventoryManagementSystem.Location.Location;
import LLDQuestions.InventoryManagementSystem.Orders.Order;
import LLDQuestions.InventoryManagementSystem.Orders.OrderManagement;
import LLDQuestions.InventoryManagementSystem.Products.Product;
import LLDQuestions.InventoryManagementSystem.Products.ProductCategory;
import LLDQuestions.InventoryManagementSystem.User.User;
import LLDQuestions.InventoryManagementSystem.User.UserController;
import LLDQuestions.InventoryManagementSystem.Warehouse.Warehouse;
import LLDQuestions.InventoryManagementSystem.Warehouse.WarehouseController;

public class App {
    private static final String biscuitCategory = "BISCUITS";
    private static final String biscuitCategoryDescription = "Biscuits, delicous";

    private static final String juiceCategory = "JUICE";
    private static final String juiceCategoryDescription = "Kello juice offsprint";
    
    private static void setupInventory(UserController userController, WarehouseController warehouseController) {

        Warehouse warehouse1 = new Warehouse(1, new Location("Bangalore East"));
        Warehouse warehouse2 = new Warehouse(2, new Location("Bangalore South"));

        Product product1 = new Product(1, "Real Juice", 120, 5);
        Product product2 = new Product(2, "B-Natural Juice", 130, 6);

        Product product3 = new Product(3, "Britannia Biscuits", 40, 15);
        Product product4 = new Product(4, "Monaco Biscuits", 50, 16);

        // Create Categories
        warehouse1.getInventory().addProductCategory(juiceCategory, juiceCategoryDescription);
        warehouse1.getInventory().addProductCategory(biscuitCategory, biscuitCategoryDescription);
        // Add Juice
        warehouse1.getInventory().getProductCategoryByKey(juiceCategory).addProduct(product1);
        warehouse1.getInventory().getProductCategoryByKey(juiceCategory).addProduct(product2);
        // Add Biscuit
        warehouse1.getInventory().getProductCategoryByKey(biscuitCategory).addProduct(product3);
        warehouse1.getInventory().getProductCategoryByKey(biscuitCategory).addProduct(product4);
        

        warehouse2.getInventory().addProductCategory(juiceCategory, juiceCategoryDescription);
        warehouse2.getInventory().addProductCategory(biscuitCategory, biscuitCategoryDescription);
        // Add Juice
        warehouse2.getInventory().getProductCategoryByKey(juiceCategory).addProduct(product1);
        warehouse2.getInventory().getProductCategoryByKey(juiceCategory).addProduct(product2);
        // Add Biscuit
        warehouse2.getInventory().getProductCategoryByKey(biscuitCategory).addProduct(product3);
        warehouse2.getInventory().getProductCategoryByKey(biscuitCategory).addProduct(product4);

        warehouseController.addWarehouse(warehouse1);
        warehouseController.addWarehouse(warehouse2);
    }

    private static int computeCost(Map<Product, Integer> productsOrdered) {
        int cost = 0;
        for(Map.Entry<Product, Integer> entry: productsOrdered.entrySet()) {
            cost += entry.getValue() * entry.getKey().getCost();
        }
        return cost;
    }

    public static void main(String[] args) throws Exception {
        WarehouseController warehouseController = WarehouseController.getInstance();
        UserController userController = UserController.getInstance();
        setupInventory(userController, warehouseController);

        User user = new User("jofra", "keddy@bunc.com", "890012333", new Location("Terraform x-35, Whitefield"));
        
        Warehouse warehouse = warehouseController.selectWarehouse();
        Inventory inventory = warehouse.getInventory();
        System.out.println("Display all the categories");
        inventory.displayProductCategories();
    
        ProductCategory productCategory = inventory.getProductCategoryByKey(biscuitCategory);
        System.out.println("Products Available in this category");
        productCategory.displayProducts();
        List<Product> products = productCategory.getProducts();

        // I really like products[0], will buy it
        Product product = products.get(0);
        user.getCart().addProductToCart(product, 2);

        inventory.updateProductCategory(biscuitCategory, product, 2);

        OrderManagement orderManagement = warehouse.getOrderManagement();
        orderManagement.createOrder(user, user.getAddress(), user.getCart().getProducts(), computeCost(user.getCart().getProducts()));
        System.out.println("Display all the categories");
        productCategory.displayProducts();
    }

}
