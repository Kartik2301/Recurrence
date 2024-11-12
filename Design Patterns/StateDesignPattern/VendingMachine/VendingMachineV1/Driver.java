package StateDesignPattern.VendingMachine.VendingMachineV1;

import StateDesignPattern.VendingMachine.VendingMachineV1.State.State;

public class Driver {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.initInventory();
        vendingMachine.displayInventory();

        try {

            System.out.println("Pressing Insert Coin Button");
            State state = vendingMachine.getState();
            state.pressInsertCoinButton(vendingMachine);
            
            System.out.println("Inserting Coins");
            state = vendingMachine.getState();
            state.insertCoin(vendingMachine, Coin.NICKEL);
            state.insertCoin(vendingMachine, Coin.QUARTER);
            
            System.out.println("Pressing Select Product Button");
            state.pressSelectProductButton(vendingMachine);

            state = vendingMachine.getState();
            state.selectProduct(vendingMachine, 103);

            vendingMachine.displayInventory();

        } catch(Exception e) {
            e.printStackTrace();
        }
    }
}
