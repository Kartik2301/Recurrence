package StateDesignPattern.VendingMachine.VendingMachineV1;

public class Item {
    private int price;
    private ItemType itemType;

    public Item(){}

    public Item(int price, ItemType itemType) {
        this.price = price;
        this.itemType = itemType;
    }

    public int getPrice() {
        return price;
    }
    public void setPrice(int price) {
        this.price = price;
    }
    public ItemType getItemType() {
        return itemType;
    }
    public void setItemType(ItemType itemType) {
        this.itemType = itemType;
    }

}
