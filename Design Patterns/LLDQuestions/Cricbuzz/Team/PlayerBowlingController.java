package LLDQuestions.Cricbuzz.Team;

import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

import LLDQuestions.Cricbuzz.Player.Player;

public class PlayerBowlingController {
    private Player currentBowler;
    private Map<Player, Integer> oversCount;
    private Deque<Player> bowlers;

    public PlayerBowlingController(Deque<Player> bowlers) {
        this.oversCount = new HashMap<>();
        this.bowlers = bowlers;
        initCurrentBowler();
    }

    public void initCurrentBowler() {
        Player bowler =  bowlers.pollFirst();
        oversCount.put(bowler, oversCount.getOrDefault(bowler, 0) + 1);
        bowlers.addLast(bowler);
        currentBowler = bowler;
    }

    public Player getCurrentBowler() {
        return currentBowler;
    }

    public void onOverChange() {
        Player bowler =  bowlers.pollFirst();
        oversCount.put(bowler, oversCount.getOrDefault(bowler, 0) + 1);
        if(oversCount.get(bowler) < 4) {
            bowlers.addLast(bowler);
        }
        currentBowler = bowler;
    }

    public void setCurrentBowler(Player currentBowler) {
        this.currentBowler = currentBowler;
    }

    public Map<Player, Integer> getOversCount() {
        return oversCount;
    }

    public void setOversCount(Map<Player, Integer> oversCount) {
        this.oversCount = oversCount;
    }

    public Deque<Player> getBowlers() {
        return bowlers;
    }

    public void setBowlers(Deque<Player> bowlers) {
        this.bowlers = bowlers;
    }
    
}
