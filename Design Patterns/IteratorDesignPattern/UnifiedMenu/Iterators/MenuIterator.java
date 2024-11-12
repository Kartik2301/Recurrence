package IteratorDesignPattern.UnifiedMenu.Iterators;

import java.util.List;

public class MenuIterator implements Iterator {
    private List<String> menuItems;
    int index = 0;

    public MenuIterator(List<String> menuItems) {
        this.menuItems = menuItems;
    }

    public boolean hasNext() {
        if(index >= menuItems.size()) {
            return false;
        }
        return true;
    }

    public String next() {
        return menuItems.get(index++);
    }
}
