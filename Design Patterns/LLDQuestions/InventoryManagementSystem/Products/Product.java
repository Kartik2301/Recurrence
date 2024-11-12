package LLDQuestions.InventoryManagementSystem.Products;

public class Product {
    private int productID;
    private String productName;
    private int cost;
    private int count;

    public Product(int productID, String productName, int cost, int count) {
        this.productID = productID;
        this.productName = productName;
        this.cost = cost;
        this.count = count;
    }

    public int getProductID() {
        return productID;
    }
    public String getProductName() {
        return productName;
    }
    public void setProductName(String productName) {
        this.productName = productName;
    }
    public int getCost() {
        return cost;
    }
    public void setCost(int cost) {
        this.cost = cost;
    }
    public int getCount() {
        return count;
    }
    public void setCount(int count) {
        this.count = count;
    }

}
