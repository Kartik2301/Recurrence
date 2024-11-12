package ZJava.NestedClasses.MemberInnerClass;

public class Main {
    public static void main(String[] args) {
        OuterClass.MemberInnerClass innerClass = new OuterClass().new MemberInnerClass();
        innerClass.print(); 
    }
}
