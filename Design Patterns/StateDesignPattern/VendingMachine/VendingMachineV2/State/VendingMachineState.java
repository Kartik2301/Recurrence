package StateDesignPattern.VendingMachine.VendingMachineV2.State;

import java.util.List;

import StateDesignPattern.VendingMachine.VendingMachineV2.Coin;
import StateDesignPattern.VendingMachine.VendingMachineV2.VendingMachine.VendingMachine;

public interface VendingMachineState {
    public void onSelectProductButtonPressed(VendingMachine vendingMachine) throws Exception;
    public boolean readInputItemCode(VendingMachine vendingMachine, int itemCode);
    public void receivePayment(VendingMachine vendingMachine, int itemId, List<Coin> coins);
    public void onTransactionAbort(VendingMachine vendingMachine) throws Exception;
    public void onMakePaymentButtonPressed(VendingMachine vendingMachine) throws Exception;
    public void dispenseProduct(VendingMachine vendingMachine, int itemCode) throws Exception;
}
