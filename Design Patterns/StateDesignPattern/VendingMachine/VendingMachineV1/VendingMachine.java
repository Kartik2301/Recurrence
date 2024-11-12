package StateDesignPattern.VendingMachine.VendingMachineV1;

import java.util.ArrayList;
import java.util.List;

import StateDesignPattern.VendingMachine.VendingMachineV1.State.IdleState;
import StateDesignPattern.VendingMachine.VendingMachineV1.State.State;

public class VendingMachine {
    private State state;
    private Inventory inventory;
    private List<Coin> coins;

    public VendingMachine() {
        state = new IdleState();
        coins = new ArrayList<>();
        inventory = new Inventory(10);
    }

    public List<Coin> getCoins() {
        return coins;
    }

    public void addCoin(Coin coin) {
        coins.add(coin);
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public void setInventory(Inventory inventory) {
        this.inventory = inventory;
    }

    public void setCoins(List<Coin> coins) {
        this.coins = coins;
    }

    public void initInventory() {
        ItemShelf [] itemShelfs = getInventory().getInventory();
        for(int i = 0; i < 10; i++) {
            Item newItem = new Item();
            if(i < 3) {
                newItem.setItemType(ItemType.COKE);
                newItem.setPrice(2000);
            } else if(i >= 3 && i < 6) {
                newItem.setItemType(ItemType.PEPSI);
                newItem.setPrice(1900);
            } else if(i >= 6 && i < 9) {
                newItem.setItemType(ItemType.WATER);
                newItem.setPrice(4000);
            } else {
                newItem.setItemType(ItemType.SODA);
                newItem.setPrice(30);
            }
            itemShelfs[i].setItem(newItem);
            itemShelfs[i].setSoldOut(false);
        }
    }

    public void displayInventory() {
        ItemShelf [] itemShelfs = getInventory().getInventory();
        for(int i = 0; i < itemShelfs.length; i++) {
            
            if(itemShelfs[i].getItem() == null) continue;

            String productDescription = "";
            switch (itemShelfs[i].getItem().getItemType()) {
                case COKE:
                    productDescription = "Coke";
                    break;
                case PEPSI:
                    productDescription = "Pepsi";
                    break;
                case WATER:
                    productDescription = "Water";
                    break;
                case SODA:
                    productDescription = "Soda";
                    break;
            }

            String productAvailability = "Yes";
            if(itemShelfs[i].isSoldOut() == true) {
                productAvailability = "No";
            }

            System.out.println("At code Number: " + itemShelfs[i].getCodeNumber() + ", We have: " + productDescription + "; price = " + itemShelfs[i].getItem().getPrice() + ". Available: " + productAvailability);
        }
    }
    
}
