package LLDQuestions.Cricbuzz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import LLDQuestions.Cricbuzz.Match.Match;
import LLDQuestions.Cricbuzz.Match.MatchType;
import LLDQuestions.Cricbuzz.Match.T20MatchType;
import LLDQuestions.Cricbuzz.Player.Person;
import LLDQuestions.Cricbuzz.Player.Player;
import LLDQuestions.Cricbuzz.Player.PlayerType;
import LLDQuestions.Cricbuzz.Scorecards.BattingScorecard;
import LLDQuestions.Cricbuzz.Scorecards.BowlingScorecard;
import LLDQuestions.Cricbuzz.Team.PlayerBattingController;
import LLDQuestions.Cricbuzz.Team.PlayerBowlingController;
import LLDQuestions.Cricbuzz.Team.Team;

public class Driver {
    private static List<String> names = Arrays.asList("James", "Fart", "George", "Kevin", "Pott", "Dog", "Jordann Hermann", "Fox", "Catt", "Dark", "You");

    private static Player createPlayer(String name) {
        return new Player(new Person(name, 20 + (int)(Math.random() % 20)), PlayerType.ALLROUNDER, new BattingScorecard(), new BowlingScorecard()); 
    }

    private static List<Player> getBatters(List<Player> allPlayers ) {
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < 6; i++) {
            players.add(allPlayers.get(i)); 
        }
        return players;
    }
    
    private static List<Player> getBowlers(List<Player> allPlayers ) {
        List<Player> players = new ArrayList<>();
        for(int i = 6; i < 11; i++) {
            players.add(allPlayers.get(i)); 
        }
        return players;
    }

    private static List<Player> getAllTeamPlayers(Team team) {
        List<Player> players = new ArrayList<>();
        for(int i = 0; i < 11; i++) {
            players.add(createPlayer(names.get(i) + " " + team.getTeamName()));
        }
        return players;
    }

    private static Team createTeam(String teamName) {
        Team team = new Team();
        team.setTeamName(teamName);

        // Create players
        List<Player> allPlayers = getAllTeamPlayers(team);
        Queue<Player> batters = new LinkedList<>(allPlayers);
        Deque<Player> bowlers = new LinkedList<>(getBowlers(allPlayers));

        team.setPlayers(new LinkedList<>(allPlayers));
        team.setReserves(new LinkedList<>(allPlayers));
        team.setPlayerBattingController(new PlayerBattingController(batters));
        team.setPlayerBowlingController(new PlayerBowlingController(bowlers));

        return team;
    }

    public static void main(String[] args) {
        // Create 2 teams
        Team India = createTeam("India");
        Team Australia = createTeam("Australia");

        // Match Type = T20
        MatchType matchType = new T20MatchType();

        // Start the match
        Match match = new Match(India, Australia, Calendar.getInstance().getTimeInMillis(), "Bangalore", matchType);
        match.startGame();
    }
}
