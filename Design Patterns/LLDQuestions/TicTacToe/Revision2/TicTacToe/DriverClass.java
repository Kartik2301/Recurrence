package LLDQuestions.TicTacToe.Revision2.TicTacToe;

import LLDQuestions.TicTacToe.Revision2.TicTacToe.Game.CentralGameClass;

public class DriverClass {
    public static void main (String [] args) {
        CentralGameClass centralGameClass = new CentralGameClass(3, 2);
        centralGameClass.startGame();
    }
}
