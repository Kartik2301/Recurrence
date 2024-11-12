package ZJava.Interfaces.FunctionalInterfaces;

@FunctionalInterface
public interface FunctionalInterfaceSample {
    public void abstractMethod();

    public default void defaultMethod1() {
        System.out.println("Default Method - Meow");
    }

    public default void defaultMethod2() {
        System.out.println("Default Method - Bark Bark");
    }

    public static void staticMethod() {
        System.out.println("Static Method - bark");
    }

    public String toString();

    private void getData() {
        System.out.println("Private Method - This is some data");
    }
}
