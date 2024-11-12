package ZJava.AccessModifiers;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Object object = new String("ghoda");
        System.out.println(object.getClass());
        object = new ArrayList<Integer>();
        System.out.println(object.getClass());
    }
}
