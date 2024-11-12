package ObserverDesignPattern.NotifyMe.Observers;

import ObserverDesignPattern.NotifyMe.Subject.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver {
    StockObservable stockObservable;
    String emailId;

    public EmailAlertObserverImpl(StockObservable stockObservable, String emailID) {
        this.stockObservable = stockObservable;
        this.emailId = emailID;
    }

    public void sendMail(String emailID, String content) {
        System.out.println("Email sent to: " + emailID);
    }

    @Override
    public void update() {
        stockObservable.getState();
        sendMail(emailId, "Product is in stock hurry up");
    }
}
