package ElevatorSystem.Elevator;

import ElevatorSystem.Directions;

public class ElevatorCarController {
    Elevator elevator;

    public ElevatorCarController(Elevator elevator) {
        this.elevator = elevator;
    }

    public void acceptRequests(int currentFloor, Directions currDirection) {

    }

    public void controlCar() {
        return;
    }

    public Elevator getElevator() {
        return elevator;
    }

    public void setElevator(Elevator elevator) {
        this.elevator = elevator;
    }
}
