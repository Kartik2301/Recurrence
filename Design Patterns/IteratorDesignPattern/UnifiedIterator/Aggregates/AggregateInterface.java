package IteratorDesignPattern.UnifiedIterator.Aggregates;

import IteratorDesignPattern.UnifiedIterator.Iterator.Iterator;

public interface AggregateInterface<T> {
    public Iterator<T> createIterator();
}
