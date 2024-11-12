package ZJava.NestedClasses.MemberInnerClass;

public class OuterClass {
    private int instanceVariable = 10;
    private int classVariable = 20;

    class MemberInnerClass {
        public void print() {
            System.out.println("Member Inner Class says hello: " + instanceVariable);
        }
    }
}
