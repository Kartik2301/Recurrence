package LLDQuestions.Calculator;

public class LeafExpression implements Expression {
    private int value;

    public LeafExpression(int value) {
        this.value = value;
    }

    @Override
    public int evaluate() {
        return value;
    }
    
}
