package MediatorDesignPattern.OnlineAuctionSystem.Auction;

import java.util.ArrayList;
import java.util.List;

import MediatorDesignPattern.OnlineAuctionSystem.Bidders.AuctionBidder;

public class CarAuction implements AuctionMediator {
    private List<AuctionBidder> auctionBidders;

    public CarAuction() {
        auctionBidders = new ArrayList<>();
    }

    @Override
    public void placeBid(AuctionBidder bidMaker, int value) {
        System.out.println();
        System.out.println("INCOMING BID, for Rs. " + value + ", by: " + bidMaker.getBidderName());

        String notification = "Bidder: " + bidMaker.getBidderName() + " made a bid for Rs. " + value;
        for(AuctionBidder bidder: auctionBidders) {
            if (!bidMaker.getBidderName().equals(bidder.getBidderName())) {
                sendBidNotifications(bidder, notification);
            }
        }
    }

    @Override
    public void sendBidNotifications(AuctionBidder bidder, String notification) {
        bidder.processNotification(notification);
    }

    public void addBidder(AuctionBidder bidder) {
        auctionBidders.add(bidder);
    }

    @Override
    public List<AuctionBidder> getBidders() {
        return auctionBidders;
    }
    
}
