package IteratorDesignPattern.UnifiedMenu.Aggregates;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import IteratorDesignPattern.UnifiedMenu.Iterators.Iterator;
import IteratorDesignPattern.UnifiedMenu.Iterators.MenuIterator;

public class Menu implements AggregateInterface {
    private List<String> menuItems;

    public Menu() {
        this.menuItems = new ArrayList<>();

        menuItems = Arrays.asList(new String[] {"Sandwich", "Dosa", "Tea", "Coffee", "Juice"});
    }

    @Override
    public Iterator createIterator() {
        return new MenuIterator(menuItems);
    }
}
