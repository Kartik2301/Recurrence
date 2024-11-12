package ZJava.Enums;

public enum CustomEnum {
    MONDAY(101, "Kelloggs"),
    TUESDAY(102, "Kerrig Barathorse"),
    WEDNESDAY(103, "Steve Harpic"),
    THURSDAY(104, "Battinson Darke"),
    FRIDAY(105, "Nuts Cerr"),
    SATURDAY(106, "Cereiolyuious Deleiouslyly"),
    SUNDAY(107, "Tub Dmp");

    private int value;
    private String name;

    private CustomEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public String getName() {
        return name;
    }


}
