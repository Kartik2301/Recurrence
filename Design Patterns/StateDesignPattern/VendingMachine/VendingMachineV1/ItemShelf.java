package StateDesignPattern.VendingMachine.VendingMachineV1;

public class ItemShelf {
    private int codeNumber;
    private boolean isSoldOut;
    private Item item;

    public int getCodeNumber() {
        return codeNumber;
    }
    public void setCodeNumber(int codeNumber) {
        this.codeNumber = codeNumber;
    }
    public boolean isSoldOut() {
        return isSoldOut;
    }
    public void setSoldOut(boolean isSoldOut) {
        this.isSoldOut = isSoldOut;
    }
    public Item getItem() {
        return item;
    }
    public void setItem(Item item) {
        this.item = item;
    }
    
}
