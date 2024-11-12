package InterpreterDesignPattern;

public class TerminalExpression implements AbstractExpression {

    private String expItem;

    public TerminalExpression(String expItem) {
        this.expItem = expItem;
    }
    
    @Override
    public int interpret(Context context) {
        return context.getValue(expItem);
    }
    
}
