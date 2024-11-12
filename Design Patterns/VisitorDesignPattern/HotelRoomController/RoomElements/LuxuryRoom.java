package VisitorDesignPattern.HotelRoomController.RoomElements;

import java.util.Iterator;

import VisitorDesignPattern.HotelRoomController.RoomVisitors.RoomVisitor;

public class LuxuryRoom implements RoomElement {
    private String amenities;

    public LuxuryRoom(String amenities) {
        this.amenities = amenities;
    }

    @Override
    public void accept(RoomVisitor visitor) {
        visitor.visit(this);
    }

    public String getAmenities() {
        return amenities;
    }
}
