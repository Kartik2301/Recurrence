package VisitorDesignPattern.HotelRoomController.RoomElements;

import VisitorDesignPattern.HotelRoomController.RoomVisitors.RoomVisitor;

public class PresidentialSuiteRoom  implements RoomElement {
    private int numberOfBeds;

    public PresidentialSuiteRoom(int numberOfBeds) {
        this.numberOfBeds = numberOfBeds;
    }

    @Override
    public void accept(RoomVisitor visitor) {
        visitor.visit(this);
    }

    public int getNumberOfBeds() {
        return numberOfBeds;
    }
}
