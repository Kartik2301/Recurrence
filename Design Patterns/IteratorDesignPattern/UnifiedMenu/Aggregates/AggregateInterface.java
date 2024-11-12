package IteratorDesignPattern.UnifiedMenu.Aggregates;

import IteratorDesignPattern.UnifiedMenu.Iterators.Iterator;

public interface AggregateInterface {
    
    public Iterator createIterator();
}
