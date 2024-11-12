package CompositeDesignPattern.Calculator;

public class Expression implements ArithmeticExpression {
    private ArithmeticExpression leftExpression;
    private ArithmeticExpression rightExpression;
    private Operation operation;

    public Expression(ArithmeticExpression leftExpression, ArithmeticExpression rightExpression, Operation operation) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operation = operation;
    }

    public int evaluate() {
        int value = 0;
        switch (operation) {
            case ADD:
                value = leftExpression.evaluate() + rightExpression.evaluate();
                break;

            case SUBTRACT:
                value = leftExpression.evaluate() - rightExpression.evaluate();
                break;

            case MULTIPLY:
                value = leftExpression.evaluate() * rightExpression.evaluate();
                break;

            case DIVIDE:
                value = leftExpression.evaluate() / rightExpression.evaluate();
                break;
        
            default:
                break;
        }

        return value;
    }
}
