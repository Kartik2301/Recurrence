package ZJava.Exception.CustomExceptions;

public class Main {
    private static void printAge(int age) {
        if(age < 0) {
            throw new NegativeAgeException("You pig, get!! Age cannot be negative ");
        }
    }

    private static void mainHelper1() throws CustomCheckedException {
        throw new CustomCheckedException("This is a custom checked exception");
    }

    private static void mainHelper2() {
        throw new CustomUnCheckedException("This is a custom un-checked exception");
    }

    public static void main(String[] args) {
        try {
            printAge(-1);
        } catch(NegativeAgeException e) {
            System.out.println(e.getMessage());
        }

        try {
            mainHelper1();
        } catch (CustomCheckedException e) {
            System.out.println(e.getMessage());
        }

        try {
            mainHelper2();
        } catch(CustomUnCheckedException e) {
            System.out.println(e.getMessage());
        }

        System.out.println("END");
    }
}
