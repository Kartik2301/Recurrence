package StateDesignPattern.VendingMachine.VendingMachineV1.State;

import java.util.List;

import StateDesignPattern.VendingMachine.VendingMachineV1.Coin;
import StateDesignPattern.VendingMachine.VendingMachineV1.Item;
import StateDesignPattern.VendingMachine.VendingMachineV1.VendingMachine;

public class SelectionState implements State {

    public SelectionState() {
        System.out.println("Currently the machine is in Selection State");
    }

    @Override
    public void pressInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        throw new UnsupportedOperationException("You cannot click on the Insert Coin Button in selection state");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new UnsupportedOperationException("You cannot insert Coin in selection state");
    }

    @Override
    public void pressSelectProductButton(VendingMachine vendingMachine) throws Exception {
        return;
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        Item item = vendingMachine.getInventory().getItem(codeNumber);
        if(item == null) {
            throw new Exception("No such item exists");
        }

        int amountPaidByUser = 0;
        for(Coin coin: vendingMachine.getCoins()) {
            amountPaidByUser += coin.value;
        }

        if(amountPaidByUser < item.getPrice()) {
            System.out.println("Insufficient Money, Product price: " + item.getPrice() + ". You Paid: " + amountPaidByUser);
            refundMoney(vendingMachine);
            throw new Exception("Insufficient Money");
        } else {
            if(amountPaidByUser > item.getPrice()) {
                getChange(amountPaidByUser - item.getPrice());
            }
            vendingMachine.setState(new DispatchState(vendingMachine, codeNumber));
        }
    }

    @Override
    public int getChange(int money) throws Exception {
        System.out.println("The change has been returned in the Coin Dispense Tray: " + money);
        return money;
    }

    @Override
    public Item dispatchProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new UnsupportedOperationException("Product cannot be dispatched in Selection state");
    }

    @Override
    public List<Coin> refundMoney(VendingMachine vendingMachine) throws Exception {
        System.out.println("Returned the full amount, please check the Coin Dispense Tray");
        vendingMachine.setState(new IdleState());
        return vendingMachine.getCoins();
    }
    
}
