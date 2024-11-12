package ZJava.Generics.Wildcards;

import java.util.List;

public class Wildcard {
    public int getListLength(List<?> list){
        return list.size();
    }

    public void printList(List<?> list) {
        for(Object item: list) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
