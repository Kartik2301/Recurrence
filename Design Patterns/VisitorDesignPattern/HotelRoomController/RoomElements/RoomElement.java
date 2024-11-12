package VisitorDesignPattern.HotelRoomController.RoomElements;

import VisitorDesignPattern.HotelRoomController.RoomVisitors.RoomVisitor;

public interface RoomElement {
    public void accept(RoomVisitor visitor);
}
