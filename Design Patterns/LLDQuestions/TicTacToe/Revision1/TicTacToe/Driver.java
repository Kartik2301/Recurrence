package LLDQuestions.TicTacToe.Revision1.TicTacToe;

public class Driver {
    public static void main(String[] args) {
        CentralGameClass game = new CentralGameClass(3);
        game.setupPlayers("jackhorse", "poltry");
        game.startGame();
    }
}
