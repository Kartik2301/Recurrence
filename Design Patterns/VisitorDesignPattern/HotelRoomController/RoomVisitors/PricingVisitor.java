package VisitorDesignPattern.HotelRoomController.RoomVisitors;

import VisitorDesignPattern.HotelRoomController.RoomElements.EconomyRoom;
import VisitorDesignPattern.HotelRoomController.RoomElements.LuxuryRoom;
import VisitorDesignPattern.HotelRoomController.RoomElements.PresidentialSuiteRoom;

public class PricingVisitor implements RoomVisitor {

    @Override
    public void visit(EconomyRoom room) {
        System.out.println(room.getClass().getSimpleName() + ", Pricing Visitor - " + room.getDailyPrice());
    }

    @Override
    public void visit(LuxuryRoom room) {
        System.out.println(room.getClass().getSimpleName() + ", Pricing Visitor - " + room.getAmenities());
    }

    @Override
    public void visit(PresidentialSuiteRoom room) {
        System.out.println(room.getClass().getSimpleName() + ", Pricing Visitor - " + room.getNumberOfBeds());
    }
    
}
