package ObserverDesignPattern.NotifyMe.Subject;

import java.util.ArrayList;
import java.util.List;

import ObserverDesignPattern.NotifyMe.Observers.NotificationAlertObserver;

public class IPhoneStockObservableImpl implements StockObservable {

    public List<NotificationAlertObserver> observersList = new ArrayList<>();
    public int stockCount = 0;

    @Override
    public void registerObserver(NotificationAlertObserver observer) {
        observersList.add(observer);
    }

    @Override
    public void removeObserver(NotificationAlertObserver observer) {
        observersList.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for(NotificationAlertObserver observer: observersList) {
            observer.update();
        }
    }

    @Override
    public void setState(int newStockCountAdded) {
        if(this.stockCount == 0) {
            this.notifyObservers();
        }
        this.stockCount += newStockCountAdded;
    }

    @Override
    public int getState() {
        return stockCount;
    }
    
}
