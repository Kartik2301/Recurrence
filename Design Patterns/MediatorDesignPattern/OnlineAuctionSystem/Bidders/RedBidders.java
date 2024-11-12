package MediatorDesignPattern.OnlineAuctionSystem.Bidders;

public class RedBidders extends AuctionBidder {

    public RedBidders(String name) {
        super(name);
    }

    @Override
    public String getBidderCategory() {
        return "RED";
    }
    
}
