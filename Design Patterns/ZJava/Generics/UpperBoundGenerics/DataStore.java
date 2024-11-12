package ZJava.Generics.UpperBoundGenerics;

public class DataStore<T extends Number> {
    T number;
    public DataStore(T number) {
        this.number = number;
    }

    public T getNumber() {
        return number;
    }
}
