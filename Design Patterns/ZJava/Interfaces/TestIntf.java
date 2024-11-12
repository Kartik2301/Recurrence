package ZJava.Interfaces;

public interface TestIntf {
    private void getWeather() {
        System.out.println("Hi Pig today is 45 degree celsius");
    }

    default void callDarke() {
        System.out.println("First check weather");
        getWeather();
    }

    public static void makeTelephonicCall() {
        System.out.println("How dare you call my staitc method, I feel exposed");
    }

    private static void whyIAmIEvenHereOrAnywhereInGeneral() {
        System.out.println("Hi i am a private static method");
    }

    abstract String toString();
}