package CompositeDesignPattern.Calculator;

public class Driver {
    public static void main(String[] args) {
        Expression innerExpression = new Expression(new Number(1), new Number(7), Operation.ADD);
        Expression expression = new Expression(new Number(2), innerExpression, Operation.MULTIPLY);
        System.out.println(expression.evaluate());
    }
}
