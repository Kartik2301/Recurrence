package LLDQuestions.Cricbuzz.Ball;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import LLDQuestions.Cricbuzz.Player.Player;
import LLDQuestions.Cricbuzz.ScoreCardUpdater.ScoreCardUpdaterObserver;

public class Ball {
    private int ballNumber;
    private RunType runType;
    private BallType ballType;
    private Player facedBy;
    private Player bowledBy;
    private List<ScoreCardUpdaterObserver> observers;

    public Ball(int ballNumber) {
        this.ballNumber = ballNumber;
        this.observers = new ArrayList<>();
    }

    public int getBallNumber() {
        return ballNumber;
    }

    public void setBallNumber(int ballNumber) {
        this.ballNumber = ballNumber;
    }

    public RunType getRunType() {
        return runType;
    }

    public void setRunType(RunType runType) {
        this.runType = runType;
    }

    public BallType getBallType() {
        return ballType;
    }

    public void setBallType(BallType ballType) {
        this.ballType = ballType;
    }

    public Player getFacedBy() {
        return facedBy;
    }

    public void setFacedBy(Player facedBy) {
        this.facedBy = facedBy;
    }

    public Player getBowledBy() {
        return bowledBy;
    }

    public void setBowledBy(Player bowledBy) {
        this.bowledBy = bowledBy;
    }

    public List<ScoreCardUpdaterObserver> getObservers() {
        return observers;
    }

    public void setObservers(List<ScoreCardUpdaterObserver> observers) {
        this.observers = observers;
    }

    public void deliverBall() {
        Random random = new Random();
        
        setBallType(BallType.LEGAL);
        
        int runTypeChoice = random.nextInt(7);
        switch (runTypeChoice) {
            case 0:
                setRunType(RunType.ONE);
                break;

            case 1:
                setRunType(RunType.ONE);
                break;

            case 2:
                setRunType(RunType.TWO);
                break;

            case 3:
                setRunType(RunType.THREE);
                break;

            case 4:
                setRunType(RunType.FOUR);
                break;

            case 5:
                setRunType(RunType.SIX);
                break;
        
            case 6:
                setRunType(RunType.WICKET);
                break;
        }

        notifObservers();
    }

    public void addObserver(ScoreCardUpdaterObserver observer) {
        observers.add(observer);
    }

    public void notifObservers() {
        for(ScoreCardUpdaterObserver observer: observers) {
            observer.update(this);
        }
    }

}
