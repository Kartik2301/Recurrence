package ZJava.NestedClasses.LocalInnerClass;

public class OuterClass {
    private int temprature = 1080;

    public void getTemprature() {
        System.out.println("Today is " + temprature + " degree Celsius");
    }

    public void weatherStation() {
        String personName = "Park";
        class LocalInnerClass {
            private int data = 20;

            public void sayHello() {
                System.out.println("Hello: " + data + ", " + personName);
                getTemprature();
            }
        }

        LocalInnerClass localInnerClass = new LocalInnerClass();
        localInnerClass.sayHello();
    }
}
