package ModelViewController.Models;

import ModelViewController.Views.BeatObserver;

public interface BeatModelInterface {
    public void on();
    public void off();
    public void setBPM(int bpm);
    public int getBPM();
    public void registerObserver(BeatObserver observer);
    public void removeObserver(BeatObserver observer);
    public void notfiyObservers();
}
