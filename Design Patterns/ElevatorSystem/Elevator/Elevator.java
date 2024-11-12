package ElevatorSystem.Elevator;

import ElevatorSystem.Directions;
import ElevatorSystem.Status;
import ElevatorSystem.Buttons.InternalButton;

public class Elevator {
    private int id;
    private int currentFloor;
    private Directions currentDirection;
    private Status status;
    private Display display;
    private InternalButton internalButton;

    public Elevator(int id, InternalButton internalButton) {
        this.id = id;
        this.internalButton = internalButton;
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public int getCurrentFloor() {
        return currentFloor;
    }
    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
    public Directions getCurrentDirection() {
        return currentDirection;
    }
    public void setCurrentDirection(Directions currentDirection) {
        this.currentDirection = currentDirection;
    }
    public Status getStatus() {
        return status;
    }
    public void setStatus(Status status) {
        this.status = status;
    }
    public Display getDisplay() {
        return display;
    }
    public void setDisplay(Display display) {
        this.display = display;
    }
    
}
