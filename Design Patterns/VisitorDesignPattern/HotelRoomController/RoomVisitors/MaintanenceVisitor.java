package VisitorDesignPattern.HotelRoomController.RoomVisitors;

import VisitorDesignPattern.HotelRoomController.RoomElements.EconomyRoom;
import VisitorDesignPattern.HotelRoomController.RoomElements.LuxuryRoom;
import VisitorDesignPattern.HotelRoomController.RoomElements.PresidentialSuiteRoom;

public class MaintanenceVisitor implements RoomVisitor {

    @Override
    public void visit(EconomyRoom room) {
        System.out.println(room.getClass().getSimpleName() + ", Maintanence Visitor, Daily Pricing - " + room.getDailyPrice());
    }

    @Override
    public void visit(LuxuryRoom room) {
        System.out.println(room.getClass().getSimpleName() + ", Maintanence Visitor, Amenities - " + room.getAmenities());
    }

    @Override
    public void visit(PresidentialSuiteRoom room) {
        System.out.println(room.getClass().getSimpleName() + ", Maintanence Visitor, Number of Beds - " + room.getNumberOfBeds());
    }
    
}
