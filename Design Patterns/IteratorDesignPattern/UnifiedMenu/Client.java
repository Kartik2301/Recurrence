package IteratorDesignPattern.UnifiedMenu;

import IteratorDesignPattern.UnifiedMenu.Aggregates.Library;
import IteratorDesignPattern.UnifiedMenu.Aggregates.Menu;
import IteratorDesignPattern.UnifiedMenu.Iterators.Iterator;

public class Client {
    private static void printAggregate(Iterator iterator) {
        while(iterator.hasNext()) {
            System.out.print(iterator.next() + "-");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Library library = new Library();
        Menu menu = new Menu();

        System.out.println("LIBRARY");
        printAggregate(library.createIterator());

        System.out.println("MENU");
        printAggregate(menu.createIterator());
    }
}
