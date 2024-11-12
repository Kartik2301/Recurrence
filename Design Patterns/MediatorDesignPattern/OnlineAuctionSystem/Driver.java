package MediatorDesignPattern.OnlineAuctionSystem;

import MediatorDesignPattern.OnlineAuctionSystem.Auction.AuctionMediator;
import MediatorDesignPattern.OnlineAuctionSystem.Auction.CarAuction;
import MediatorDesignPattern.OnlineAuctionSystem.Bidders.AuctionBidder;
import MediatorDesignPattern.OnlineAuctionSystem.Bidders.BlueBidders;
import MediatorDesignPattern.OnlineAuctionSystem.Bidders.RedBidders;

public class Driver {
    public static void main(String[] args) {
        AuctionMediator auctionMediator = new CarAuction();

        AuctionBidder bidder1 = new RedBidders("George");
        AuctionBidder bidder2 = new BlueBidders("Jordann Hermann");
        AuctionBidder bidder3 = new RedBidders("Nate");

        bidder1.setMediator(auctionMediator);
        bidder2.setMediator(auctionMediator);
        bidder3.setMediator(auctionMediator);

        bidder1.placeBid(34);
        bidder2.placeBid(56);
        bidder1.placeBid(78);
        bidder3.placeBid(134);
    }
}
