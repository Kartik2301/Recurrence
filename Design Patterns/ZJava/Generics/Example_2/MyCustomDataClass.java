package ZJava.Generics.Example_2;

public class MyCustomDataClass<T> {
    private T internalState;

    public MyCustomDataClass(T internalState) {
        this.internalState = internalState;
    }

    public T getState() {
        return internalState;
    }

    public void setState(T internalState) {
        this.internalState = internalState;
    }
}
