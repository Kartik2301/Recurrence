package ObserverDesignPattern.NotifyMe.Subject;

import ObserverDesignPattern.NotifyMe.Observers.NotificationAlertObserver;

public interface StockObservable {
    public void registerObserver(NotificationAlertObserver observer);
    public void removeObserver(NotificationAlertObserver observer);
    public void notifyObservers();
    public void setState(int newStockCountAdded);
    public int getState();
}
