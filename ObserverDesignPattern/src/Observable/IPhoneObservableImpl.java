package Observable;

import Observer.NotificationAlertObserver;

import java.util.ArrayList;
import java.util.List;

public class IPhoneObservableImpl implements StockObservable{
    List<NotificationAlertObserver> observerList;
    int stockCount;

    public IPhoneObservableImpl(){
        observerList = new ArrayList<>();
        stockCount = 0;
    }

    @Override
    public void add(NotificationAlertObserver observer) {
        observerList.add(observer);
    }

    @Override
    public void remove(NotificationAlertObserver observer) {
        observerList.remove(observer);
    }

    @Override
    public void notifySubscriber() {
        for(NotificationAlertObserver observer: observerList){
            observer.update();
        }
    }

    @Override
    public void setStockCount(int newStockAdded) {
        if(stockCount == 0){
            notifySubscriber();
        }
        stockCount += newStockAdded;
    }

    @Override
    public int getStockCount() {
        return this.stockCount;
    }
}
