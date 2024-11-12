package LLDQuestions.SnakeAndLadder.Revision2;

import java.util.Random;

public class Dice {
    public int rollDice() {
        Random random = new Random(System.currentTimeMillis());

        return 1 + random.nextInt(6);
    }
}
