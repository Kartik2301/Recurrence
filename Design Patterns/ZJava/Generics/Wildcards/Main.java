package ZJava.Generics.Wildcards;

import java.util.ArrayList;
import java.util.List;

import ZJava.Generics.TypeSafety.DataStore;

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        for(int i = 1; i <= 5; i++) {
            list.add(i);
        }

        Wildcard wildcard = new Wildcard();
        System.out.println(wildcard.getListLength(list));

        wildcard.printList(list);
        
        List<String> dataFiles = new ArrayList<>();
        dataFiles.add("George");
        dataFiles.add("Keddy");

        DataStore store = new DataStore();
        store.addItemGenerics(dataFiles, "Kelloggs Jordann");

        for(String item: dataFiles) {
            System.out.println(item);
        }
    }
}
