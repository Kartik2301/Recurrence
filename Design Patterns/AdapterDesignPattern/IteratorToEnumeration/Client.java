package AdapterDesignPattern.IteratorToEnumeration;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;

public class Client {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 5; i++) {
            list.add(i);
        }
        
        Enumeration<Object> iteratorAdapter = new IteratorAdapter(list.iterator());

        while(iteratorAdapter.hasMoreElements()) {
            System.out.println(iteratorAdapter.nextElement());
        }
    }
}
