package IteratorDesignPattern.UnifiedIterator;

import IteratorDesignPattern.UnifiedIterator.Aggregates.IntegerArrayAggregate;
import IteratorDesignPattern.UnifiedIterator.Aggregates.StringListAggregate;
import IteratorDesignPattern.UnifiedIterator.Iterator.Iterator;

public class Main {
    private static <T> void printAggregate(Iterator<T> iterator) {
        while (iterator.hasNext()) {
            System.out.print(iterator.next() + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        IntegerArrayAggregate integerArrayAggregate = new IntegerArrayAggregate();
        printAggregate(integerArrayAggregate.createIterator());

        StringListAggregate stringListAggregate = new StringListAggregate();
        printAggregate(stringListAggregate.createIterator());
    }
}
