package LLDQuestions.InventoryManagementSystem.Warehouse;

import LLDQuestions.InventoryManagementSystem.Inventory.Inventory;
import LLDQuestions.InventoryManagementSystem.Location.Location;
import LLDQuestions.InventoryManagementSystem.Orders.OrderManagement;

public class Warehouse {
    private int warehouseID;
    private Location location;
    private Inventory inventory;
    private OrderManagement orderManagement;
    private boolean isFunctional;

    public Warehouse(int warehouseID, Location location) {
        this.warehouseID = warehouseID;
        this.location = location;
        this.inventory = new Inventory();
        this.isFunctional = true;
        this.orderManagement = new OrderManagement();
    }

    public int getWarehouseID() {
        return warehouseID;
    }

    public void setWarehouseID(int warehouseID) {
        this.warehouseID = warehouseID;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public OrderManagement getOrderManagement() {
        return orderManagement;
    }

    public void setOrderManagement(OrderManagement orderManagement) {
        this.orderManagement = orderManagement;
    }

    public boolean isFunctional() {
        return isFunctional;
    }

    public void setFunctional(boolean isFunctional) {
        this.isFunctional = isFunctional;
    }
}
