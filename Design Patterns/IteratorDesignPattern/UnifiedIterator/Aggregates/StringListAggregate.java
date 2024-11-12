package IteratorDesignPattern.UnifiedIterator.Aggregates;

import java.util.ArrayList;
import java.util.List;

import IteratorDesignPattern.UnifiedIterator.ArrayIterators.ListIterator;
import IteratorDesignPattern.UnifiedIterator.Iterator.Iterator;

public class StringListAggregate implements AggregateInterface<String> {
    private List<String> list;

    public StringListAggregate() {
        list = new ArrayList<>();

        list.add("Kers");
        list.add("Pop");
        list.add("Tuplo");
        list.add("Stx");
    }

    @Override
    public Iterator<String> createIterator() {
        return new ListIterator<String>(list);
    }
}
