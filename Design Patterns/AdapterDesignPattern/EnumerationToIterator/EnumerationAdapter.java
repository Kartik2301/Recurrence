package AdapterDesignPattern.EnumerationToIterator;

import java.util.Enumeration;
import java.util.Iterator;

public class EnumerationAdapter implements Iterator<Object> {
    private Enumeration<Object> enumeration;

    public EnumerationAdapter(Enumeration<Object> enumeration) {
        this.enumeration = enumeration;
    }

    @Override
    public boolean hasNext() {
        return enumeration.hasMoreElements();
    }

    @Override
    public Object next() {
        return enumeration.nextElement();
    }

    @Override
    public void remove() {
        throw new UnsupportedOperationException("remove");
    }
    
}
