package LLDQuestions.InventoryManagementSystem.Warehouse.WarehouseSelectionStrategy;

import java.util.List;

import LLDQuestions.InventoryManagementSystem.Warehouse.Warehouse;

public interface WarehouseSelectionStrategy {
    public Warehouse selectWarehouse(List<Warehouse> warehouses);
}
