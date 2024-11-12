package LLDQuestions.Calculator;

public class ArithmeticExpression implements Expression {
    private Expression leftExpression;
    private Expression rightExpression;
    private char operator;

    public ArithmeticExpression(Expression leftExpression, Expression rightExpression, char operator) {
        this.leftExpression = leftExpression;
        this.rightExpression = rightExpression;
        this.operator = operator;
    }

    @Override
    public int evaluate() {
        switch (operator) {
            case '+':
                return leftExpression.evaluate() + rightExpression.evaluate();
            case '-':
                return leftExpression.evaluate() - rightExpression.evaluate();
            case '/':
                return leftExpression.evaluate() / rightExpression.evaluate();
            case '*':
                return leftExpression.evaluate() * rightExpression.evaluate();
        }
        return 0;
    }
}
