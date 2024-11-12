package ZJava.Generics.UpperBoundGenerics;

public class Main {
    public static void main(String[] args) {
        DataStore<Integer> store = new DataStore<>(23);
        System.out.println(store.getNumber());
    }
}
