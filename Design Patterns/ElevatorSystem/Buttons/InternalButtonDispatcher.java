package ElevatorSystem.Buttons;

import java.util.List;

import ElevatorSystem.Elevator.ElevatorCarController;

public class InternalButtonDispatcher {
    List<ElevatorCarController> elevatorCarControllers;

    public InternalButtonDispatcher(List<ElevatorCarController> elevatorCarControllers) {
        this.elevatorCarControllers = elevatorCarControllers;
    }
}
