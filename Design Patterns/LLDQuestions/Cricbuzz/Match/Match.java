package LLDQuestions.Cricbuzz.Match;

import java.security.Timestamp;

import LLDQuestions.Cricbuzz.Innings.Innings;
import LLDQuestions.Cricbuzz.Team.Team;

public class Match {
    private Team teamA;
    private Team teamB;
    private long startTime;
    private String venue;
    private Team tossWinner;
    private MatchType matchType;
    private Innings [] innings;

    public Match(Team teamA, Team teamB, long startTime, String venue, MatchType matchType) {
        this.teamA = teamA;
        this.teamB = teamB;
        this.startTime = startTime;
        this.venue = venue;
        this.matchType = matchType;
        this.innings = new Innings[2];
    }

    private Team toss(Team a, Team b) {
        return a;
    }

    public void startGame() {
        tossWinner = toss(teamA, teamB);

        Team battingTeam = tossWinner;
        Team bowlingTeam = (tossWinner.getTeamName().equals(teamA.getTeamName())) ? teamB: teamA;

        innings[0] = new Innings(battingTeam, bowlingTeam, matchType);
        int firstInningsScore = innings[0].startInnings(5000);

        System.out.println(battingTeam.getTeamName() + " scored: " + firstInningsScore);

        innings[1] = new Innings(bowlingTeam, battingTeam, matchType);
        int secondInningsScore = innings[1].startInnings(firstInningsScore);

        System.out.println(bowlingTeam.getTeamName() + " scored: " + secondInningsScore);

        if(secondInningsScore > firstInningsScore) {
            System.out.println(bowlingTeam.getTeamName() + " won the match");
        } else if(firstInningsScore > secondInningsScore) {
            System.out.println(battingTeam.getTeamName() + " won the match");
        } else {
            System.out.println("Match is a tie");
        }
    }
    
}
