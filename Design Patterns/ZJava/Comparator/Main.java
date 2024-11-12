package ZJava.Comparator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class CustomComparator implements Comparator<Integer> {
    @Override
    public int compare(Integer a, Integer b) {
        return a - b;
    }
}

public class Main {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.addAll(Arrays.asList(2, 33, 15, 26, 109, 12, 113, 104, 16, 20, 8));

        List<String> names = Arrays.asList("george", "mark", "dim", "keller", "hippo");

        Collections.sort(list, (Integer val1, Integer val2) -> val1 - val2);
        Collections.sort(names, (String val1, String val2) -> val1.length() - val2.length());

        System.out.println(names);
    }
}
