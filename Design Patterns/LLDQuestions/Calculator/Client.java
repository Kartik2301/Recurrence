package LLDQuestions.Calculator;

public class Client {
    public static void main(String[] args) {
        Expression expression = new ArithmeticExpression(
                                    new ArithmeticExpression(new LeafExpression(7), new LeafExpression(15), '*'), 
                                    new ArithmeticExpression(new LeafExpression(100), new LeafExpression(40), '-'), 
                           '+');

        System.out.println(expression.evaluate());
    }
}
