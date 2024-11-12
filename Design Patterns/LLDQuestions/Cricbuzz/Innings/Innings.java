package LLDQuestions.Cricbuzz.Innings;

import java.util.ArrayList;
import java.util.List;

import LLDQuestions.Cricbuzz.Ball.Ball;
import LLDQuestions.Cricbuzz.Ball.RunType;
import LLDQuestions.Cricbuzz.Match.MatchType;
import LLDQuestions.Cricbuzz.Over.Over;
import LLDQuestions.Cricbuzz.Player.Player;
import LLDQuestions.Cricbuzz.ScoreCardUpdater.BattingScoreCardUpdaterObserver;
import LLDQuestions.Cricbuzz.ScoreCardUpdater.BowlingScoreCardUpdaterObserver;
import LLDQuestions.Cricbuzz.Team.Team;

public class Innings {
    private Team battingTeam;
    private Team bowlingTeam;
    private List<Over> overs;
    private MatchType matchType;

    public Innings(Team battingTeam, Team bowlingTeam, MatchType matchType) {
        this.battingTeam = battingTeam;
        this.bowlingTeam = bowlingTeam;
        this.matchType = matchType;
        this.overs = new ArrayList<>();
    }

    public int startInnings(int target) {
        int totalOvers = matchType.getNumberOfOversInTheMatch();

        int score = 0;
        int wickets = 0;
        boolean inningsOver = false;

        Ball ball = new Ball(0);
        ball.addObserver(new BattingScoreCardUpdaterObserver());
        ball.addObserver(new BowlingScoreCardUpdaterObserver());

        for(int i = 0; i < totalOvers; i++) {
            Over over = new Over(i + 1);
            Player currentBowler = bowlingTeam.getPlayerBowlingController().getCurrentBowler();

            for(int j = 1; j <= 6; j++) {
                Player currentBatsman = battingTeam.getPlayerBattingController().getStriker();
                
                ball.setBallNumber(i);
                ball.setFacedBy(currentBatsman);
                ball.setBowledBy(currentBowler);
                ball.deliverBall();

                over.addBall(ball);

                score += ball.getRunType().value;

                if(ball.getRunType() == RunType.WICKET) {
                    wickets++;
                    try {
                        battingTeam.getPlayerBattingController().onWicketFall();
                    } catch(Exception e) {
                        e.printStackTrace();
                    }
                } else {
                    if(ball.getRunType().value % 2 == 1) {
                        battingTeam.getPlayerBattingController().swapBatters();
                    }
                }

                if(wickets == 10 || score > target) {
                    inningsOver = true;
                    break;
                }

                if(ball.getRunType() == RunType.WICKET) {
                    System.out.println("Over: " + i + ", Ball: " + j + " Wicket!!");
                } else {
                    System.out.println("Over: " + i + ", Ball: " + j + " Runs scored = " + ball.getRunType().value);
                }
                
            }
            
            overs.add(over);
            bowlingTeam.getPlayerBowlingController().onOverChange();

            if(inningsOver) {
                // Display Scorecard
                battingTeam.displayScorecard();
                break;
            }
        }

        return score;
    }
}
