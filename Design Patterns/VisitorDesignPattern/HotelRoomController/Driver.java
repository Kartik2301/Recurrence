package VisitorDesignPattern.HotelRoomController;

import VisitorDesignPattern.HotelRoomController.RoomElements.EconomyRoom;
import VisitorDesignPattern.HotelRoomController.RoomElements.LuxuryRoom;
import VisitorDesignPattern.HotelRoomController.RoomElements.PresidentialSuiteRoom;
import VisitorDesignPattern.HotelRoomController.RoomElements.RoomElement;
import VisitorDesignPattern.HotelRoomController.RoomVisitors.MaintanenceVisitor;
import VisitorDesignPattern.HotelRoomController.RoomVisitors.PricingVisitor;
import VisitorDesignPattern.HotelRoomController.RoomVisitors.RoomVisitor;

public class Driver {
    public static void main(String[] args) {
        RoomElement luxuryRoom = new LuxuryRoom("Fridge, AC, TV, Microwave");
        RoomElement economyRoom = new EconomyRoom(1000);
        RoomElement presidentialSuiteRoom = new PresidentialSuiteRoom(4);

        RoomVisitor pricingVisitor = new PricingVisitor();
        RoomVisitor maintanenceVisitor = new MaintanenceVisitor();

        luxuryRoom.accept(maintanenceVisitor);
        economyRoom.accept(maintanenceVisitor);
        presidentialSuiteRoom.accept(maintanenceVisitor);

        luxuryRoom.accept(pricingVisitor);
        economyRoom.accept(pricingVisitor);
        presidentialSuiteRoom.accept(pricingVisitor);
    }
}
