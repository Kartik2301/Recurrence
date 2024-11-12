package LLDQuestions.SnakeAndLadder.Revision2;

public class Driver {
    public static void main(String[] args) {
        CentralGameClass game = new CentralGameClass(5);
        String [] names = {"Timux", "Gax", "Linux", "Reyx"};
        game.setUpPlayers(names);
        game.startGame();
    }
}
