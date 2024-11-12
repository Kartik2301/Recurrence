package LLDQuestions.Cricbuzz.Team;

import java.util.Queue;

import LLDQuestions.Cricbuzz.Player.Player;

public class PlayerBattingController {
    private Queue<Player> nextPlayers;
    private Player striker;
    private Player nonStriker;

    public PlayerBattingController(Queue<Player> nextPlayers) {
        this.nextPlayers = nextPlayers;
        this.striker = initStriker();
        this.nonStriker = initNonStriker();
    }

    public Player initStriker() {
        return nextPlayers.poll();
    }

    public Player initNonStriker() {
        return nextPlayers.poll();
    }

    public Player getStriker() {
        return striker;
    }

    public Player getNonStriker() {
        return nonStriker;
    }
    
    public void onWicketFall() throws Exception {
        if(nextPlayers.size() == 0) {
            throw new Exception("The team has been bundled out");
        }
        striker = nextPlayers.poll();
    }

    public void swapBatters() {
        Player cur = striker;
        striker = nonStriker;
        nonStriker = cur;
    }
}
