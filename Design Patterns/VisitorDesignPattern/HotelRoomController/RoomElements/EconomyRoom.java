package VisitorDesignPattern.HotelRoomController.RoomElements;

import VisitorDesignPattern.HotelRoomController.RoomVisitors.RoomVisitor;

public class EconomyRoom implements RoomElement {
    private int dailyPrice;

    public EconomyRoom(int dailyPrice) {
        this.dailyPrice = dailyPrice;
    }

    @Override
    public void accept(RoomVisitor visitor) {
        visitor.visit(this);
    }

    public int getDailyPrice() {
        return dailyPrice;
    }
    
}
