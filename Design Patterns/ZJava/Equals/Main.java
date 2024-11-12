package ZJava.Equals;

import java.sql.Timestamp;
import java.util.Calendar;

public class Main {
    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Timestamp(System.currentTimeMillis()));
        calendar.add(Calendar.DAY_OF_WEEK, -14);
        Timestamp purchaseTimestamp = new Timestamp(calendar.getTime().getTime());

        Laptop mac1 = new Laptop("Macbook Pro 16 inch", 7, purchaseTimestamp);
        Laptop mac2 = new Laptop("Macbook Pro 16 inch", 7, purchaseTimestamp);

        if(mac1.equals(mac2)) {
            System.out.println("The laptops are one and the same");
        } else {
            System.out.println("NOPE");
        }

        String a = new String("abc").intern();
        String b = new String("abc").intern();
        String c = new String("abc");

        System.out.println("Are they same ? " + (a == b));
        System.out.println("Are they same ? " + (a == c));
    }
}
