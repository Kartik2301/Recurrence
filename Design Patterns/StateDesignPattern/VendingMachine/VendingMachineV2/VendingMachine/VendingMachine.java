package StateDesignPattern.VendingMachine.VendingMachineV2.VendingMachine;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import StateDesignPattern.VendingMachine.VendingMachineV2.Coin;
import StateDesignPattern.VendingMachine.VendingMachineV2.State.IdleState;
import StateDesignPattern.VendingMachine.VendingMachineV2.State.VendingMachineState;
import StateDesignPattern.VendingMachine.VendingMachineV2.VendingMachine.Inventory.Inventory;
import StateDesignPattern.VendingMachine.VendingMachineV2.VendingMachine.Item.Item;

public class VendingMachine {
    private VendingMachineState vendingMachineState;
    private Inventory inventory;
    private List<Coin> coinList;
    private List<Item> items = Arrays.asList(new Item("Coke", 20),
                                             new Item("Pepsi", 15),
                                             new Item("Lime", 10),
                                             new Item("Bisleri", 20),
                                             new Item("Apple Juice", 50),
                                             new Item("Banana Shake", 60),
                                             new Item("Sprite", 30),
                                             new Item("Soda", 45),
                                             new Item("Orange Juice", 50));

    public VendingMachine() {
        this.vendingMachineState = new IdleState();
        this.coinList = new ArrayList<>();
        this.inventory = new Inventory();
        this.inventory.preInitInventory(3, 3);
        this.inventory.initInventory(items, 3, 3);
    }

    public VendingMachineState getVendingMachineState() {
        return vendingMachineState;
    }

    public void setVendingMachineState(VendingMachineState vendingMachineState) {
        this.vendingMachineState = vendingMachineState;
    }

    public void addCoins(List<Coin> coins) {
        for(Coin coin: coins) {
            this.coinList.add(coin);
        }
    }

    public Inventory getInventory() {
        return this.inventory;
    }
}
