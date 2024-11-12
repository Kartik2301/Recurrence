package MediatorDesignPattern.OnlineAuctionSystem.Auction;

import java.util.ArrayList;
import java.util.List;

import MediatorDesignPattern.OnlineAuctionSystem.Bidders.AuctionBidder;

public class NoAuctionMediator implements AuctionMediator {

    @Override
    public void placeBid(AuctionBidder bidMaker, int value) {}

    @Override
    public void sendBidNotifications(AuctionBidder bidder, String notification) {}

    @Override
    public void addBidder(AuctionBidder bidder) {}

    @Override
    public List<AuctionBidder> getBidders() {
        return new ArrayList<>();
    }
    
}
