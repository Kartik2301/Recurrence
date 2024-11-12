package ZJava.Interfaces.FunctionalInterfaces;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class TypesOfFuncInterfaces {
    public static void main(String[] args) {
        Consumer<String> consumerFunctionalInterface = (String input) -> System.out.println("Hi Jackson, you are a: " + input);
        consumerFunctionalInterface.accept("Donk Monk");

        Supplier<String> supplierFunctionalInterface = () -> "Horse Morse Code";
        System.out.println(supplierFunctionalInterface.get());

        Function<Integer, String> functionFunctionalInterface = (Integer input) -> "Hi Gosov, you are: " + input + " years old";
        System.out.println(functionFunctionalInterface.apply(40));

        Predicate<Integer> predicateFunctionalInterface = (Integer input) -> {
            if(input >= 25) {
                return true;
            }
            return false;
        };
        System.out.println(predicateFunctionalInterface.test(10));
    }
}
