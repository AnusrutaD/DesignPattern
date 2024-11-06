package Observer;

import Observable.StockObservable;

public class EmailAlertObserverImpl implements NotificationAlertObserver{

    String emailId;
    StockObservable observable;

    public EmailAlertObserverImpl(String emailId, StockObservable observable){
        this.observable = observable;
        this.emailId = emailId;
    }

    @Override
    public void update() {
        sendEmail(emailId, "Product is in stock hurry up!");
    }

    private void sendEmail(String emailId, String msg){
        System.out.println("mail sent to: " + emailId);
        // Send the actual email to the end user
    }
}
