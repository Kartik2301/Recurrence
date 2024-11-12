package ZJava.Generics.TypeSafety;

import java.util.List;

public class DataStore {
    public <T> void addItemGenerics(List<T> list, T item) {
        list.add(item);
    }
  
    public void addItemWildcard(List<? extends Object> list, Object item) {
        System.out.println(list.size());
    }
}
