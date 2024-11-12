package ModelViewController;

import ModelViewController.Controllers.BeatController;
import ModelViewController.Controllers.ControllerInterface;
import ModelViewController.Models.BeatModel;
import ModelViewController.Models.BeatModelInterface;

public class DJTestDrive {
    public static void main(String[] args) {
        BeatModelInterface model = new BeatModel();
        ControllerInterface controller = new BeatController(model);
    }
}
