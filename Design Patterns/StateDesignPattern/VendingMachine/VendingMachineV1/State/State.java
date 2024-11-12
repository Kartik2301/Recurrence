package StateDesignPattern.VendingMachine.VendingMachineV1.State;

import java.util.List;

import StateDesignPattern.VendingMachine.VendingMachineV1.Coin;
import StateDesignPattern.VendingMachine.VendingMachineV1.Item;
import StateDesignPattern.VendingMachine.VendingMachineV1.VendingMachine;

public interface State {
    public void pressInsertCoinButton(VendingMachine vendingMachine) throws Exception;
    public void insertCoin(VendingMachine vendingMachine, Coin coin) throws Exception;
    public void pressSelectProductButton(VendingMachine vendingMachine) throws Exception;
    public void selectProduct(VendingMachine vendingMachine, int codeNumber) throws Exception;
    public int getChange(int money) throws Exception;
    public Item dispatchProduct(VendingMachine vendingMachine, int codeNumber) throws Exception;
    public List<Coin> refundMoney(VendingMachine vendingMachine) throws Exception;
}
