package MediatorDesignPattern.OnlineAuctionSystem.Auction;

import java.util.List;

import MediatorDesignPattern.OnlineAuctionSystem.Bidders.AuctionBidder;

public interface AuctionMediator {
    public void placeBid(AuctionBidder bidMaker, int value);
    public void sendBidNotifications(AuctionBidder bidder, String notification);
    public void addBidder(AuctionBidder bidder);
    public List<AuctionBidder> getBidders();
}
