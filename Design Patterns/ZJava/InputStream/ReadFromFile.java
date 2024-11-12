package ZJava.InputStream;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

public class ReadFromFile {
    public static void main(String[] args) {
        try {
            InputStream inputStream = new BufferedInputStream(new FileInputStream("/Users/kanema/OS-Codes/ZJava/InputStream/data.txt"));

            int c;
            while((c = inputStream.read()) >= 0) {
                System.out.print((char)c);
            }

            System.out.println();

            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
