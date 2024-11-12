package LLDQuestions.InventoryManagementSystem.Warehouse;

import java.util.ArrayList;
import java.util.List;

import LLDQuestions.InventoryManagementSystem.Warehouse.WarehouseSelectionStrategy.NearestToUserStrategy;
import LLDQuestions.InventoryManagementSystem.Warehouse.WarehouseSelectionStrategy.WarehouseSelectionStrategy;

public class WarehouseController {
    private List<Warehouse> warehouses;
    private WarehouseSelectionStrategy warehouseSelectionStrategy;
    private static volatile WarehouseController warehouseControllerInstance;

    private WarehouseController() {
        this.warehouses = new ArrayList<>();
        this.warehouseSelectionStrategy = new NearestToUserStrategy();
    }

    public Warehouse selectWarehouse() {
        return this.warehouseSelectionStrategy.selectWarehouse(warehouses);
    }

    public void addWarehouse(Warehouse warehouse) {
        this.warehouses.add(warehouse);
    }

    public void removeWarehouse(Warehouse warehouse) {
        this.warehouses.remove(warehouse);
    }

    public void setWarehouseSelectionStrategy(WarehouseSelectionStrategy warehouseSelectionStrategy) {
        this.warehouseSelectionStrategy = warehouseSelectionStrategy;
    }

    public static WarehouseController getInstance() {
        if(warehouseControllerInstance == null) {
            synchronized(WarehouseController.class) {
                if(warehouseControllerInstance == null) {
                    warehouseControllerInstance = new WarehouseController();
                }
            }
        }
        return warehouseControllerInstance;
    }
    
}
