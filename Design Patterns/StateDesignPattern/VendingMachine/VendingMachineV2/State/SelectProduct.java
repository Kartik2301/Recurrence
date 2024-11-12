package StateDesignPattern.VendingMachine.VendingMachineV2.State;

import java.util.List;

import StateDesignPattern.VendingMachine.VendingMachineV2.Coin;
import StateDesignPattern.VendingMachine.VendingMachineV2.VendingMachine.VendingMachine;

public class SelectProduct implements VendingMachineState {

    @Override
    public void onSelectProductButtonPressed(VendingMachine vendingMachine) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onSelectProductButtonPressed'");
    }

    @Override
    public boolean readInputItemCode(VendingMachine vendingMachine, int itemCode) {
        // Sanity: Check If the code is correct
        return true;
    }

    @Override
    public void receivePayment(VendingMachine vendingMachine, int itemId, List<Coin> coins) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'receivePayment'");
    }

    @Override
    public void onTransactionAbort(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachineState(new IdleState());
    }

    @Override
    public void onMakePaymentButtonPressed(VendingMachine vendingMachine) throws Exception {
        vendingMachine.setVendingMachineState(new MakePayment());
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine, int itemCode) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispenseProduct'");
    }
    
}
