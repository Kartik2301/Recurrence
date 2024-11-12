package LLDQuestions.SnakeAndLadder.Revision1.SnakeAndLadders.Player;

public class Player {
    String userName;
    int currentPosition;

    public Player(String userName, int currentPosition) {
        this.userName = userName;
        this.currentPosition = currentPosition;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void setCurrentPosition(int currentPosition) {
        this.currentPosition = currentPosition;
    }

    
}
