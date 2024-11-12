package VisitorDesignPattern.HotelRoomController.RoomVisitors;

import VisitorDesignPattern.HotelRoomController.RoomElements.EconomyRoom;
import VisitorDesignPattern.HotelRoomController.RoomElements.LuxuryRoom;
import VisitorDesignPattern.HotelRoomController.RoomElements.PresidentialSuiteRoom;

public interface RoomVisitor {
    public void visit(EconomyRoom room);
    public void visit(LuxuryRoom room);
    public void visit(PresidentialSuiteRoom room);
}
