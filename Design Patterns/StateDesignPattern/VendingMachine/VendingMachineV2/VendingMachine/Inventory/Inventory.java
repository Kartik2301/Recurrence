package StateDesignPattern.VendingMachine.VendingMachineV2.VendingMachine.Inventory;

import java.util.ArrayList;
import java.util.List;

import StateDesignPattern.VendingMachine.VendingMachineV2.VendingMachine.Item.Item;
import StateDesignPattern.VendingMachine.VendingMachineV2.VendingMachine.ItemShelf.ItemShelf;

public class Inventory {
    private List<ItemShelf> itemShelfs;

    public Inventory() {
        this.itemShelfs = new ArrayList<>();
    }

    public void preInitInventory(int rowsTotal, int colsTotal) {
        int itemCodeStart = 101;

        for(int i = 0; i < rowsTotal; i++) {
            for(int j = 0; j < colsTotal; j++) {
                this.itemShelfs.add(new ItemShelf(i, j, null, false, itemCodeStart++));
            }
        }
    }

    public void initInventory(List<Item> items, int rowsTotal, int colsTotal) {
        int index = 0;

        for(int i = 0; i < items.size(); i++) {
            ItemShelf iShelf = this.itemShelfs.get(i);
            iShelf.setItem(items.get(index++));
        }
    }

    public void displayInventory() {
        for(ItemShelf itemShelf: itemShelfs) {
            String itemName = (itemShelf.getItem() == null) ? "Empty" : itemShelf.getItem().getName() + " Rs. " + itemShelf.getItem().getCost();
            System.out.println(itemShelf.getRow() + "," + itemShelf.getCol() + "-" +  
                               itemShelf.getItemCode() + " : " + itemName);
        }
    }

    private ItemShelf findItemShelf(int itemCode) {
        for(ItemShelf itemShelf: itemShelfs) {
            if(itemShelf.getItemCode() == itemCode) {
                return itemShelf;
            }
        }
        return null;
    }

    public void updateInventoryDecrement(int itemCode) {
        ItemShelf itemShelf = findItemShelf(itemCode);
        if(itemShelf != null) {
            itemShelf.setItem(null);
            itemShelf.setEmpty(true);
            itemShelf.setItemCode(0);
        }
    }

    public int getItemCost(int itemCode) {
        ItemShelf itemShelf = findItemShelf(itemCode);

        return (itemShelf == null || itemShelf.getItem() == null) ? -1: itemShelf.getItem().getCost();
    }
}
