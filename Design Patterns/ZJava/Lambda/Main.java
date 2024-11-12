package ZJava.Lambda;

public class Main {
    public static void main(String[] args) {
        LambdaInterface lambda1 = (input) -> "This is an implementation of the Lambda Interface: " + input;
        System.out.println(lambda1.handleMethod("Kellogg"));

        LambdaInterface lambda2 = (input) -> "Get out: " + input;
        System.out.println(lambda2.handleMethod("Stepht"));

        Trade trade = new Trade() {

            @Override
            public String makeTrade(String input) {
                return  "Trade Made: " + input;
            }

            @Override
            public String cancelMethod(String input) {
                return "Trade Cancelled: " + input;
            }
        };

        System.out.println(trade.makeTrade("Kellog"));
        System.out.println(trade.cancelMethod("Silverpig"));
    }
}
