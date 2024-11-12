package ZJava.Generics.Example_1;

public class PrintArrays {
    private Integer [] intArray;
    private String [] stringArray;
    private Double [] doubleArray;
    private Character [] charArray;

    PrintArrays(int size) {
        intArray = new Integer[size];
        stringArray = new String[size];
        doubleArray = new Double[size];
        charArray = new Character[size];

        for(int i = 0; i < size; i++) {
            intArray[i] = i;
            stringArray[i] = Integer.toString(i * 5);
            doubleArray[i] = ((double) i / 5.0);
            charArray[i] = stringArray[i].charAt(0);
        }

        printArray(intArray);
        printArray(charArray);
        printArray(stringArray);
        printArray(doubleArray);
    }

    public <T> void printArray(T [] array) {
        for(T item: array) {
            System.out.print(item + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        new PrintArrays(10);
    }
}
