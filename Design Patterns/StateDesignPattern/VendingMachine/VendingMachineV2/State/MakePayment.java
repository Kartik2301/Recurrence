package StateDesignPattern.VendingMachine.VendingMachineV2.State;

import java.util.List;

import StateDesignPattern.VendingMachine.VendingMachineV2.Coin;
import StateDesignPattern.VendingMachine.VendingMachineV2.VendingMachine.VendingMachine;

public class MakePayment implements VendingMachineState {

    @Override
    public void onSelectProductButtonPressed(VendingMachine vendingMachine) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onSelectProductButtonPressed'");
    }

    @Override
    public boolean readInputItemCode(VendingMachine vendingMachine, int itemCode) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'readInputItemCode'");
    }

    @Override
    public void receivePayment(VendingMachine vendingMachine, int itemCode, List<Coin> coins) {
        // Payment via UPI / Coins
        int moneyDeposited = 0;
        for(Coin coin: coins) {
            moneyDeposited += coin.value;
        }

        int itemCost = vendingMachine.getInventory().getItemCost(itemCode);
        int change = 0;

        if(moneyDeposited < itemCost) {
            // Insufficient Funds
            change = moneyDeposited;

            vendingMachine.setVendingMachineState(new IdleState());

            System.out.println("Insufficient Funds, please try again");

        } else {
            // Process order
            
            if(moneyDeposited >= itemCost) {
                change = moneyDeposited - itemCost;

                vendingMachine.setVendingMachineState(new DispenseState());
            }

            vendingMachine.setVendingMachineState(new DispenseState());
        }

        if(change > 0) {
            processChange(change);
        }

    }

    @Override
    public void onTransactionAbort(VendingMachine vendingMachine) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onTransactionAbort'");
    }

    @Override
    public void onMakePaymentButtonPressed(VendingMachine vendingMachine) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'onMakePaymentButtonPressed'");
    }

    @Override
    public void dispenseProduct(VendingMachine vendingMachine, int itemCode) throws Exception {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'dispenseProduct'");
    }

    public void processChange(int change) {
        System.out.println("Processing Change: " + change);
    }
    
}
