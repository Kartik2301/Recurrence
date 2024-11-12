package StateDesignPattern.VendingMachine.VendingMachineV2;

import java.util.Arrays;

import StateDesignPattern.VendingMachine.VendingMachineV2.State.DispenseState;
import StateDesignPattern.VendingMachine.VendingMachineV2.State.VendingMachineState;
import StateDesignPattern.VendingMachine.VendingMachineV2.VendingMachine.VendingMachine;

public class Driver {
    public static void main(String[] args) throws Exception {
        int itemCode = 103;
        VendingMachine vendingMachine = new VendingMachine();
        vendingMachine.getInventory().displayInventory();

        VendingMachineState vendingMachineState = vendingMachine.getVendingMachineState();
        vendingMachineState.onSelectProductButtonPressed(vendingMachine);

        vendingMachineState = vendingMachine.getVendingMachineState();
        if(vendingMachineState.readInputItemCode(vendingMachine, itemCode) == false) {
            System.err.println("Incorrect Product Code");
            return;
        }
        vendingMachineState.onMakePaymentButtonPressed(vendingMachine);

        vendingMachineState = vendingMachine.getVendingMachineState();
        vendingMachineState.receivePayment(vendingMachine, itemCode, Arrays.asList(Coin.FIVE, Coin.TWO, Coin.FIVE, Coin.ONE, Coin.TWO));

        vendingMachineState = vendingMachine.getVendingMachineState();

        if(vendingMachineState instanceof DispenseState) {
            vendingMachineState.dispenseProduct(vendingMachine, itemCode);
        }
    }
}
