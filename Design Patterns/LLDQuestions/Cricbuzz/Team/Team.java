package LLDQuestions.Cricbuzz.Team;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

import LLDQuestions.Cricbuzz.Player.Player;

public class Team {
    private String teamName;
    private Queue<Player> players;
    private Queue<Player> reserves;
    private PlayerBattingController playerBattingController;
    private PlayerBowlingController playerBowlingController;

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Queue<Player> getPlayers() {
        return players;
    }

    public void setPlayers(Queue<Player> players) {
        this.players = players;
    }

    public Queue<Player> getReserves() {
        return reserves;
    }

    public void setReserves(Queue<Player> reserves) {
        this.reserves = reserves;
    }

    public PlayerBattingController getPlayerBattingController() {
        return playerBattingController;
    }

    public void setPlayerBattingController(PlayerBattingController playerBattingController) {
        this.playerBattingController = playerBattingController;
    }

    public PlayerBowlingController getPlayerBowlingController() {
        return playerBowlingController;
    }

    public void setPlayerBowlingController(PlayerBowlingController playerBowlingController) {
        this.playerBowlingController = playerBowlingController;
    }

    public void displayScorecard() {
        List<Player> playersList = new ArrayList<>(players);
        for(Player player: playersList) {
            int runsScored = player.getBattingScorecard().getRuns();
            if(runsScored == -1) {
                System.out.println("Player: " + player.getPerson().getName() + " DNB");
            } else {
                System.out.println("Player: " + player.getPerson().getName() + " scored: " + runsScored);
            }
        }
    }
    
}
