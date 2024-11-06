import Observable.IPhoneObservableImpl;
import Observable.StockObservable;
import Observer.EmailAlertObserverImpl;
import Observer.MobileAlertObserverImpl;
import Observer.NotificationAlertObserver;

public class Store {
    public static void main(String[] args) {
        StockObservable iphoneStockObservable = new IPhoneObservableImpl();

        NotificationAlertObserver observer1 = new EmailAlertObserverImpl("abc1@gmail.com", iphoneStockObservable);
        NotificationAlertObserver observer2 = new EmailAlertObserverImpl("abc2@gmail.com", iphoneStockObservable);
        NotificationAlertObserver observer3 = new MobileAlertObserverImpl("9876543210", iphoneStockObservable);

        iphoneStockObservable.add(observer1);
        iphoneStockObservable.add(observer2);
        iphoneStockObservable.add(observer3);

        iphoneStockObservable.setStockCount(10);
        iphoneStockObservable.setStockCount(0);
        iphoneStockObservable.setStockCount(100);
    }
}
