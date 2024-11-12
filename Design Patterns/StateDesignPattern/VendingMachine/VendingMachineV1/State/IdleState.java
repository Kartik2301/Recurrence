package StateDesignPattern.VendingMachine.VendingMachineV1.State;

import java.util.List;

import StateDesignPattern.VendingMachine.VendingMachineV1.Coin;
import StateDesignPattern.VendingMachine.VendingMachineV1.Item;
import StateDesignPattern.VendingMachine.VendingMachineV1.VendingMachine;

public class IdleState implements State {

    public IdleState() {
        System.out.println("The Vending machine is in the Idle state");
    }

    @Override
    public void pressInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setState(new CollectMoneyState());
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new UnsupportedOperationException("You cannot insert coin in idle state");
    }

    @Override
    public void pressSelectProductButton(VendingMachine vendingMachine) throws Exception {
        throw new UnsupportedOperationException("First you need to click on Insert Coin Button");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new UnsupportedOperationException("You cannot select prodcut in idle state");
    }

    @Override
    public int getChange(int money) throws Exception {
        throw new UnsupportedOperationException("First you need to click on Insert Coin Button");
    }

    @Override
    public Item dispatchProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new UnsupportedOperationException("First you need to click on Insert Coin Button");
    }

    @Override
    public List<Coin> refundMoney(VendingMachine vendingMachine) throws Exception {
        throw new UnsupportedOperationException("First you need to click on Insert Coin Button");
    }
    
}
