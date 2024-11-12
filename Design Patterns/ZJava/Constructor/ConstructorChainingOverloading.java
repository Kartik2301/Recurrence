package ZJava.Constructor;

public class ConstructorChainingOverloading {
    public ConstructorChainingOverloading() {
        System.out.println("Constructor - No param");
    }

    public ConstructorChainingOverloading(int a) {
        this();
        System.out.println("Constructor - One argument: a");
    }

    public ConstructorChainingOverloading(int a, int b) {
        this(a);
        System.out.println("Constructor - Two arguments: a and b");
    }
}
