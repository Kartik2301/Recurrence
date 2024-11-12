package ZJava.Generics.Example_2;

public class Main {
    public static void main(String[] args) {
        MyCustomDataClass<String> stringData = new MyCustomDataClass<>("Harpool");
        MyCustomDataClass<Integer> integerData = new MyCustomDataClass<>(28);
        MyCustomDataClass<Double> doubleData = new MyCustomDataClass<>(3.33);

        System.out.println(stringData.getState());
        System.out.println(integerData.getState());
        System.out.println(doubleData.getState());
    }
}
