package IteratorDesignPattern.UnifiedIterator.Aggregates;

import IteratorDesignPattern.UnifiedIterator.ArrayIterators.ArrayIterator;
import IteratorDesignPattern.UnifiedIterator.Iterator.Iterator;

public class IntegerArrayAggregate implements AggregateInterface<Integer> {
    Integer [] elements;

    public IntegerArrayAggregate() {
        elements = new Integer[20];

        for(int i = 0; i < 20; i++) {
            elements[i] = 7 * i + 5;
        }
    }

    @Override
    public Iterator<Integer> createIterator() {
        return new ArrayIterator<Integer>(elements);
    }
}
