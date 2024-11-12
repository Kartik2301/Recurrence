package StateDesignPattern.VendingMachine.VendingMachineV1.State;

import java.util.List;

import StateDesignPattern.VendingMachine.VendingMachineV1.Coin;
import StateDesignPattern.VendingMachine.VendingMachineV1.Item;
import StateDesignPattern.VendingMachine.VendingMachineV1.VendingMachine;

public class CollectMoneyState implements State {

    @Override
    public void pressInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        throw new UnsupportedOperationException("You have already pressed this button");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        vendingMachine.addCoin(coin);
    }

    @Override
    public void pressSelectProductButton(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setState(new SelectionState());
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new UnsupportedOperationException("First you need to click the Select Product Button");
    }

    @Override
    public int getChange(int money) throws Exception {
        throw new UnsupportedOperationException("First you need to click the Select Product Button");
    }

    @Override
    public Item dispatchProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new UnsupportedOperationException("First you need to click the Select Product Button");
    }

    @Override
    public List<Coin> refundMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("Returned the full amount, please check the Coin Dispense Tray");
        vendingMachine.setState(new IdleState());
        return vendingMachine.getCoins();
    }
    
}
