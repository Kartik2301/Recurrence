package LLDQuestions.SnakeAndLadder.Revision1.SnakeAndLadders.Dice;

import java.util.Random;

public class Dice {
    int diceCount;

    public Dice(int diceCount) {
        this.diceCount = diceCount;
    }

    public int rollDice() {
        return new Random().nextInt(6) + 1;
    }
}
