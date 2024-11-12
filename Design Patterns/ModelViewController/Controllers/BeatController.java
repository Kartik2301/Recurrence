package ModelViewController.Controllers;

import ModelViewController.Models.BeatModelInterface;
import ModelViewController.Views.DJView;

public class BeatController implements ControllerInterface {
    private BeatModelInterface model;
    private DJView view;

    public BeatController(BeatModelInterface model) {
        this.model = model;
        this.view = new DJView(model, this);
    }

    @Override
    public void increaseBPM() {
        int bpm = model.getBPM() + 1;
        model.setBPM(bpm);
    }

    @Override
    public void decreaseBPM() {
        int bpm = model.getBPM() - 1;
        model.setBPM(bpm);
    }

    @Override
    public void setBPM(int bpm) {
        model.setBPM(bpm);
    }

    @Override
    public void start() {
        model.on();
        view.enableConfigButtons();
        view.disableOnButton();
    }

    @Override
    public void stop() {
        model.off();
        view.resetConfigs();
    }
    
}
