package StateDesignPattern.VendingMachine.VendingMachineV2;

public enum Coin {
    ONE(1),
    TWO(2),
    FIVE(5);

    public int value;
    
    private Coin(int value) {
        this.value = value;
    }
}
