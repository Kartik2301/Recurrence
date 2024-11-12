package StateDesignPattern.VendingMachine.VendingMachineV1;

public enum Coin {
    PENNY (100),
    NICKEL (500),
    DIME (1000),
    QUARTER (2500);

    public int value;
    Coin(int value) {
        this.value = value;
    }
}
