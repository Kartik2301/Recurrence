package DecoratorDesignPattern.IODecorator;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Client {
    public static void main(String[] args) {
        int c;
        try {
            InputStream inputStream = new UpperCaseInputStream(
                                        new BufferedInputStream(
                                            new FileInputStream("DecoratorDesignPattern/IODecorator/test.txt")));

            while ((c = inputStream.read()) >= 0) {
                System.out.print((char) c);
            }

            System.out.println();

            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
