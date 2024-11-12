package IteratorDesignPattern.UnifiedIterator.ArrayIterators;

import IteratorDesignPattern.UnifiedIterator.Iterator.Iterator;

public class ArrayIterator<T> implements Iterator<T> {
    private int index = 0;
    private T[] elements;

    public ArrayIterator(T[] elements) {
        this.elements = elements;
    }

    @Override
    public boolean hasNext() {
        if(index >= elements.length) return false;
        return true;
    }

    @Override
    public T next() {
        return elements[index++];
    }
    
}
