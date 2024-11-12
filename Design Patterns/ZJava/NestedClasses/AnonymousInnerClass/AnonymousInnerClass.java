package ZJava.NestedClasses.AnonymousInnerClass;

abstract class Truck {
    public abstract void run();
}

public class AnonymousInnerClass {
    public static void main(String[] args) {
        Truck truck = new Truck() {
            @Override
            public void run() {
                System.out.println("Speed increases exponentially");
            }
        };

        truck.run();
    }
}
