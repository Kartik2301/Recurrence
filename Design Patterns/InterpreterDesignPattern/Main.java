package InterpreterDesignPattern;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        context.addValue("a", 10);
        context.addValue("b", 5);
        context.addValue("c", 40);
        context.addValue("d", 2);

        int result = new MultiplyNonTerminalExpression(
            new MultiplyNonTerminalExpression(new TerminalExpression("c"), new TerminalExpression("d")), 
            new AddNonTerminalExpression(new TerminalExpression("a"), new TerminalExpression("b"))).interpret(context);
        System.out.println(result);
    }
}
