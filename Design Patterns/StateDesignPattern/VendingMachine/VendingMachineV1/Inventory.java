package StateDesignPattern.VendingMachine.VendingMachineV1;

public class Inventory {
    ItemShelf [] inventory = null;

    public Inventory(int itemCount) {
        inventory = new ItemShelf[itemCount];
        setupInventory();
    }

    public ItemShelf[] getInventory() {
        return inventory;
    }

    public void setInventory(ItemShelf[] inventory) {
        this.inventory = inventory;
    }

    public void setupInventory() {
        int startCodeNumber = 101;
        for(int i = 0; i < inventory.length; i++) {
            inventory[i] = new ItemShelf();
            inventory[i].setCodeNumber(startCodeNumber);
            inventory[i].setSoldOut(true);
            startCodeNumber++;
        }
    }

    public void addItem(Item item, int codeNumber) throws Exception {
        for(ItemShelf itemShelf: inventory) {
            if(itemShelf.getCodeNumber() == codeNumber) {
                itemShelf.setItem(item);
                itemShelf.setSoldOut(false);
            } else {
                throw new Exception("Item already present you cannot add more you babbit");
            }
        }
    }

    public Item getItem(int codeNumber) {
        for(ItemShelf itemShelf: inventory) {
            if(itemShelf.getCodeNumber() == codeNumber) {
                return itemShelf.getItem();
            }
        }
        return null;
    }

    public void updateSoldOutItem(int codeNumber) {
        for(ItemShelf itemShelf: inventory) {
            if(itemShelf.getCodeNumber() == codeNumber) {
                itemShelf.setSoldOut(true);
                itemShelf.setItem(null);
            }
        }
    }
}
