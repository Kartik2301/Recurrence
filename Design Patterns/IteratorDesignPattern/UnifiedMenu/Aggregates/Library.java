package IteratorDesignPattern.UnifiedMenu.Aggregates;

import IteratorDesignPattern.UnifiedMenu.Iterators.Iterator;
import IteratorDesignPattern.UnifiedMenu.Iterators.LibraryIterator;

public class Library implements AggregateInterface {
    private String [] libraryItems;

    public Library() {
        libraryItems = new String[5];
        String [] bookNames = {"Hello", "Bye", "Good Book", "Mobile", "Water"};
        
        for(int i = 0; i < libraryItems.length; i++) {
            libraryItems[i] = bookNames[i];
        }
    } 

    @Override
    public Iterator createIterator() {
        return new LibraryIterator(libraryItems);
    }
}
