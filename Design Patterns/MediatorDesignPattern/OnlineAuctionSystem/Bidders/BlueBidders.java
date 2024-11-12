package MediatorDesignPattern.OnlineAuctionSystem.Bidders;

public class BlueBidders extends AuctionBidder {

    public BlueBidders(String name) {
        super(name);
    }

    @Override
    public String getBidderCategory() {
        return "Blue";
    }
    
}
