package LLDQuestions.Cricbuzz.Ball;

public enum RunType {
    DOT(0),
    ONE (1),
    TWO (2),
    THREE (3),
    FOUR (4),
    SIX (6),
    WICKET (0);

    public final int value;

    private RunType(int value) {
        this.value = value;
    }
}
