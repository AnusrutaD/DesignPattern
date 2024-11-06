package Observer;

import Observable.StockObservable;

public class MobileAlertObserverImpl implements NotificationAlertObserver {

    String phoneNumber;
    private StockObservable stockObservable;

    public MobileAlertObserverImpl(String phoneNumber, StockObservable stockObservable){
        this.stockObservable = stockObservable;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public void update() {
        sendMessage(this.phoneNumber, "Product is in stock hurry up!");
    }

    private void sendMessage(String phoneNumber, String message){
        System.out.println("message sent to: " + phoneNumber);
        // Send the Actual message to the user phone number
    }
}
