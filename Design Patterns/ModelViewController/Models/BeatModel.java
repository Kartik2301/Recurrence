package ModelViewController.Models;

import java.util.ArrayList;
import java.util.List;

import ModelViewController.Views.BeatObserver;

public class BeatModel implements BeatModelInterface {
    private int bpm;
    private boolean isRunning;
    private List<BeatObserver> observers;

    public BeatModel() {
        bpm = 0;
        isRunning = false;
        observers = new ArrayList<>();
    }

    @Override
    public void on() {
        System.out.println("Music Player Turned On");
        isRunning = true;
        bpm = 80;
        notfiyObservers();
    }

    @Override
    public void off() {
        System.out.println("Music Player Turned Off");
        isRunning = false;
        bpm = 0;
        notfiyObservers();
    }

    @Override
    public void setBPM(int bpm) {
        this.bpm = bpm;
        notfiyObservers();
    }

    @Override
    public int getBPM() {
        return bpm;
    }

    @Override
    public void registerObserver(BeatObserver observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(BeatObserver observer) {
        observers.remove(observer);
    }

    @Override
    public void notfiyObservers() {
        for(BeatObserver beatObserver: observers) {
            beatObserver.update();
        }
    }
    
}
