package ElevatorSystem.Buttons;

import java.util.List;

import ElevatorSystem.Elevator.ElevatorCarController;

public class ExternalButtonDispatcher {
    List<ElevatorCarController> elevatorCarControllers;

    public ExternalButtonDispatcher(List<ElevatorCarController> elevatorCarControllers) {
        this.elevatorCarControllers = elevatorCarControllers;
    }
}
