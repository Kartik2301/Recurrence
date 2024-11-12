package LLDQuestions.InventoryManagementSystem.Inventory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import LLDQuestions.InventoryManagementSystem.Products.Product;
import LLDQuestions.InventoryManagementSystem.Products.ProductCategory;

public class Inventory {
    private Map<String, ProductCategory> productCategories;

    public Inventory() {
        this.productCategories = new HashMap<>();
    }
    
    public void addProductCategory(String categoryName, String categoryDescription) {
        productCategories.put(categoryName, new ProductCategory(categoryName, categoryDescription));
    }

    public void removeProductCategory(ProductCategory productCategory) {
        productCategories.remove(productCategory);
    }

    public void updateProductCategory(String categoryName, Product product, int count) throws Exception {
        if(count > product.getCount()) {
            throw new Exception("Not Enough Items available");
        }
        productCategories.get(categoryName).decrementCount(product, count);
    }

    public void displayProductCategories() {
        for(String productCategory: productCategories.keySet()) {
            System.out.println(productCategory);
        }
    }

    public void addProductToCategory() {

    }

    public ProductCategory getProductCategoryByKey(String categoryName) {
        return productCategories.get(categoryName);
    }

}
