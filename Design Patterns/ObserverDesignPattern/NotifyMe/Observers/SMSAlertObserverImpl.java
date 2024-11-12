package ObserverDesignPattern.NotifyMe.Observers;

import ObserverDesignPattern.NotifyMe.Subject.StockObservable;

public class SMSAlertObserverImpl implements NotificationAlertObserver {
    StockObservable stockObservable;
    String phoneNumber;

    public SMSAlertObserverImpl(StockObservable stockObservable, String phoneNumber) {
        this.stockObservable = stockObservable;
        this.phoneNumber = phoneNumber;
    }

    public void sendSMS(String content, String phoneNumer) {
        System.out.println("SMS successfully sent to: " + phoneNumber);
    }

    @Override
    public void update() {
        stockObservable.getState();
        sendSMS("Hurry up, product is in stock", phoneNumber);
    }
    
}
