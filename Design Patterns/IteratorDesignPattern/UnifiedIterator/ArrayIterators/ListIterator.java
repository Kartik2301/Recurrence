package IteratorDesignPattern.UnifiedIterator.ArrayIterators;

import java.util.List;

import IteratorDesignPattern.UnifiedIterator.Iterator.Iterator;

public class ListIterator<T> implements Iterator<T> {
    private int index = 0;
    private List<T> elements;

    public ListIterator(List<T> elements) {
        this.elements = elements;
    }

    @Override
    public boolean hasNext() {
        if(index >= elements.size()) return false;
        return true;
    }

    @Override
    public T next() {
        return elements.get(index);
    }
    
}
