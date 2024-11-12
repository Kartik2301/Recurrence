package StateDesignPattern.VendingMachine.VendingMachineV2.VendingMachine.ItemShelf;

import StateDesignPattern.VendingMachine.VendingMachineV2.VendingMachine.Item.Item;

public class ItemShelf {
    private int itemCode;
    private int row;
    private int col;
    private Item item;
    private boolean isEmpty;

    public ItemShelf(int row, int col, Item item, boolean isEmpty, int itemCode) {
        this.row = row;
        this.col = col;
        this.item = item;
        this.isEmpty = isEmpty;
        this.itemCode = itemCode;
    }

    public int getRow() {
        return row;
    }
    
    public int getCol() {
        return col;
    }
    
    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public boolean isEmpty() {
        return isEmpty;
    }

    public void setEmpty(boolean isEmpty) {
        this.isEmpty = isEmpty;
    }

    public int getItemCode() {
        return itemCode;
    }

    public void setItemCode(int itemCode) {
        this.itemCode = itemCode;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public void setCol(int col) {
        this.col = col;
    }

    
}

