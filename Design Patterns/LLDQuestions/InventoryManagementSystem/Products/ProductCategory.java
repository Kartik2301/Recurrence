package LLDQuestions.InventoryManagementSystem.Products;

import java.util.ArrayList;
import java.util.List;

public class ProductCategory {
    private List<Product> products;
    private String categoryName;
    private String categoryDescription;

    public ProductCategory(String categoryName, String categoryDescription) {
        this.products = new ArrayList<>();
        this.categoryDescription = categoryDescription;
        this.categoryName = categoryName;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    public String getCategoryDescription() {
        return categoryDescription;
    }

    public void setCategoryDescription(String categoryDescription) {
        this.categoryDescription = categoryDescription;
    }

    public void addProduct(Product product) {
        products.add(product);
    }

    public void displayProducts() {
        for(Product product: products) {
            System.out.println(product.getProductName() + " - " + product.getCount());
        }
    }

    public List<Product> getProducts() {
        return products;
    }

    public void decrementCount(Product product, int count) {
        int index = products.indexOf(product);
        int updatedCount = product.getCount() - count;
        product.setCount(updatedCount);

        if(updatedCount == 0) {
            products.remove(index);
        } 
    }
    
}
