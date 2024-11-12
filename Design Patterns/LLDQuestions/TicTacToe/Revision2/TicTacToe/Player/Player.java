package LLDQuestions.TicTacToe.Revision2.TicTacToe.Player;

import LLDQuestions.TicTacToe.Revision2.TicTacToe.Pieces.PlayingPiece;

public class Player {
    private String userName;
    private PlayingPiece playingPiece;

    public Player(String userName, PlayingPiece playingPiece) {
        this.userName = userName;
        this.playingPiece = playingPiece;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public PlayingPiece getPlayingPiece() {
        return playingPiece;
    }

    public void setPlayingPiece(PlayingPiece playingPiece) {
        this.playingPiece = playingPiece;
    }
}
