package LLDQuestions.InventoryManagementSystem.Warehouse.WarehouseSelectionStrategy;

import java.util.List;

import LLDQuestions.InventoryManagementSystem.Warehouse.Warehouse;

public class NearestToUserStrategy implements WarehouseSelectionStrategy {
    public Warehouse selectWarehouse(List<Warehouse> warehouses) {
        return warehouses.get(0);
    }
}
