package ZJava.NestedClasses.StaticNestedClass;

public class OuterClass {
    private int instanceVariable  = 10;
    private static int classVariable = 12;

    static class StaticNestedClass {
        public void sayHello() {
            System.out.println("Hi There nut: " + classVariable);
        } 
    }
}
