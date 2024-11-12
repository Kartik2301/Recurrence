package ObserverDesignPattern.NotifyMe;

import ObserverDesignPattern.NotifyMe.Observers.EmailAlertObserverImpl;
import ObserverDesignPattern.NotifyMe.Observers.NotificationAlertObserver;
import ObserverDesignPattern.NotifyMe.Observers.SMSAlertObserverImpl;
import ObserverDesignPattern.NotifyMe.Subject.IPhoneStockObservableImpl;
import ObserverDesignPattern.NotifyMe.Subject.StockObservable;

public class Store {
    public static void main (String [] args) {
        StockObservable iphoneStockObservable = new IPhoneStockObservableImpl();

        // Create observers
        NotificationAlertObserver observer1 = new EmailAlertObserverImpl(iphoneStockObservable, "customer1234@gmail.com");
        NotificationAlertObserver observer2 = new SMSAlertObserverImpl(iphoneStockObservable, "8183459662");
        NotificationAlertObserver observer3 = new EmailAlertObserverImpl(iphoneStockObservable, "cust45@gmail.com");

        iphoneStockObservable.registerObserver(observer1);
        iphoneStockObservable.registerObserver(observer2);
        iphoneStockObservable.registerObserver(observer3);

        iphoneStockObservable.setState(10);
        iphoneStockObservable.setState(10);
    }
}
