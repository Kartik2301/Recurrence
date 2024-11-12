package ZJava.Enums;

public class Main {
    public static void main(String[] args) {
        // Iterating over enum
        for(Days day: Days.values()) {
            System.out.println(day + " - " + day.ordinal());
        }

        Days friday = Days.valueOf("FRIDAY");
        System.out.println(friday.name() + " = " + friday.ordinal());

        for(CustomEnum customEnum: CustomEnum.values()) {
            System.out.println(customEnum + " - " + customEnum.getValue() + ", " + customEnum.getName() + ", " + customEnum.ordinal());
        }

        for(EnumMethods enumMethods: EnumMethods.values()) {
            System.out.println(enumMethods.name() + " says: ");
            enumMethods.handleMethod();
            enumMethods.makeNoise();
        }

        EnumMethods.randomStaticMethod();
    }
}
