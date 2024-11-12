package MediatorDesignPattern.OnlineAuctionSystem.Bidders;

import MediatorDesignPattern.OnlineAuctionSystem.Auction.AuctionMediator;
import MediatorDesignPattern.OnlineAuctionSystem.Auction.NoAuctionMediator;

public abstract class AuctionBidder {
    private AuctionMediator auctionMediator;
    private String name;

    public AuctionBidder(String name) {
        this.name = name;
        this.auctionMediator = new NoAuctionMediator();
    }

    public void setMediator(AuctionMediator auctionMediator) {
        this.auctionMediator = auctionMediator;
        this.auctionMediator.addBidder(this);
    }

    public void placeBid(int value) {
        auctionMediator.placeBid(this, value);
    }

    public void processNotification(String notification) {
        System.out.println("Notification received by: " + this.name + ", " + this.getBidderCategory() + "\nBID DETAILS: " + notification);
    }

    public String getBidderName() {
        return name;
    }

    public abstract String getBidderCategory();
    
}
