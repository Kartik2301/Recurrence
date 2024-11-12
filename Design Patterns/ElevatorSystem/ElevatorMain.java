package ElevatorSystem;

import java.util.ArrayList;
import java.util.List;

import ElevatorSystem.Buttons.InternalButton;
import ElevatorSystem.Buttons.InternalButtonDispatcher;
import ElevatorSystem.Elevator.Elevator;
import ElevatorSystem.Elevator.ElevatorCarController;

public class ElevatorMain {
    public static void main(String [] args) {
        // Create 2 elevators
        List<ElevatorCarController> elevatorCarControllers = new ArrayList<>();

        for(int i = 0; i < 2; i++) {
            elevatorCarControllers.add(new ElevatorCarController(null));
        }

        for(int i = 0; i < 2; i++) {
            InternalButton button = new InternalButton(new InternalButtonDispatcher(elevatorCarControllers));
            Elevator elevator = new Elevator(i + 1, button);

            ElevatorCarController elevatorCarController = elevatorCarControllers.get(i);
            elevatorCarController.setElevator(elevator);
            elevatorCarControllers.set(i, elevatorCarController);
        }
    }

}
