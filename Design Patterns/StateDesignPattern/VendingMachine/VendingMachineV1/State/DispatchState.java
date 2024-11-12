package StateDesignPattern.VendingMachine.VendingMachineV1.State;

import java.util.List;

import StateDesignPattern.VendingMachine.VendingMachineV1.Coin;
import StateDesignPattern.VendingMachine.VendingMachineV1.Item;
import StateDesignPattern.VendingMachine.VendingMachineV1.VendingMachine;

public class DispatchState implements State {

    public DispatchState(VendingMachine vendingMachine, int codeNumber) throws Exception {
        System.out.println("Currently the machine is in Dispatch State");
        dispatchProduct(vendingMachine, codeNumber);
    }

    @Override
    public void pressInsertCoinButton(VendingMachine vendingMachine) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'pressInsertCoinButton'");
    }

    @Override
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'insertCoin'");
    }

    @Override
    public void pressSelectProductButton(VendingMachine vendingMachine) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'pressSelectProductButton'");
    }

    @Override
    public void selectProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'selectProduct'");
    }

    @Override
    public int getChange(int monney) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'getChange'");
    }

    @Override
    public Item dispatchProduct(VendingMachine vendingMachine, int codeNumber) throws Exception {
        System.out.println("Product has been dispatched");
        Item item = vendingMachine.getInventory().getItem(codeNumber);
        vendingMachine.getInventory().updateSoldOutItem(codeNumber);
        vendingMachine.setState(new IdleState());
        return item;
    }

    @Override
    public List<Coin> refundMoney(VendingMachine vendingMachine) throws Exception {
        throw new UnsupportedOperationException("Unimplemented method 'refundMoney'");
    }
    
}
