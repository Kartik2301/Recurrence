package LLDQuestions.Cricbuzz.Over;

import java.util.ArrayList;
import java.util.List;

import LLDQuestions.Cricbuzz.Ball.Ball;

public class Over {
    private List<Ball> balls;
    private int overNumber;

    public Over(int overNumber) {
        this.balls = new ArrayList<>();
        this.overNumber = overNumber;
    }

    public void addBall(Ball ball) {
        this.balls.add(ball);
    }

}
