# DesignPattern



# Strategy Design Pattern

## Overview
The Strategy Design Pattern is a powerful solution for making systems more scalable and adaptable to change. By isolating varying behaviors into distinct, interchangeable strategies, it allows for cleaner code and minimizes duplication.

## Problem Statement
In systems where certain components (or "children") share the same capabilities, code duplication often arises. If two or more components have similar behavior that is not needed by others, managing and maintaining this duplicated code can become a challenge, impacting both scalability and readability.

## Solution: Strategy Design Pattern
The Strategy Design Pattern addresses this issue by defining a family of algorithms, encapsulating each one, and making them interchangeable. Components with the same capabilities can use a shared strategy, reducing code duplication and improving system flexibility.

# Example: 
## Payment Processing System
Imagine a payment processing system that supports multiple payment methods (e.g., Credit Card, PayPal, and Bitcoin). Each payment method has a different way of processing payments, but they all share the same basic structure. Using the Strategy Design Pattern, we can encapsulate each payment method in a separate strategy class.

![Strategy Pattern UML Diagram](sandbox:/![img.png](img.png)mnt/data/Strategy_Pattern_UML.png)

### Without the Strategy Design Pattern
In this scenario, all payment methods (Credit Card, PayPal, and Bitcoin) are handled in a single `PaymentProcessor` class. This leads to tightly coupled code, making it harder to maintain and extend as new payment methods are added.

```java
public class PaymentProcessor {
    public void processPayment(String paymentType, double amount, String detail) {
        switch (paymentType) {
            case "CreditCard":
                System.out.println("Paid $" + amount + " using Credit Card: " + detail);
                break;
            case "PayPal":
                System.out.println("Paid $" + amount + " using PayPal: " + detail);
                break;
            case "Bitcoin":
                System.out.println("Paid $" + amount + " using Bitcoin wallet: " + detail);
                break;
            default:
                System.out.println("Invalid payment method.");
                break;
        }
    }
}
```

#### Issues with This Approach
1. **Code Duplication:** Each payment type has its own logic embedded in the main class, making the code harder to maintain and expand.
2. **Limited Scalability:** Adding a new payment method means modifying the `PaymentProcessor` class, violating the Open/Closed Principle (i.e., the class is not closed for modification).
3. **Complexity and Readability:** As the number of payment methods grows, the `switch` statement can become unwieldy, making the code harder to read and debug.
4. **Tightly Coupled Code:** The payment logic is tightly coupled with the `PaymentProcessor` class, leading to less flexibility.


### With the Strategy Design Pattern
Using the Strategy Design Pattern, we can move each payment method to its own class, making the system modular and easier to extend. Here’s how the code changes:

#### Step 1: Define the `PaymentStrategy` Interface
Each payment method will implement this interface, defining its own `pay` method.
```java
public interface PaymentStrategy {
    void pay(double amount);
}
```

#### Step 2: Implement Each Payment Strategy Separately
Each payment type has its own class, making the code modular and easy to manage.
```java
public class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card: " + cardNumber);
    }
}

public class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal: " + email);
    }
}

public class BitcoinPayment implements PaymentStrategy {
    private String walletAddress;

    public BitcoinPayment(String walletAddress) {
        this.walletAddress = walletAddress;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Bitcoin wallet: " + walletAddress);
    }
}
```

#### Step 3: Context Class
The `PaymentContext` class uses a `PaymentStrategy` to execute the payment, allowing clients to choose the payment method at runtime.
```java
public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    public PaymentContext(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void executePayment(double amount) {
        paymentStrategy.pay(amount);
    }
}
```
#### Step 4: Usage
Now, clients can select a specific payment strategy without modifying the `PaymentContext` class.
```java
public class Main {
    public static void main(String[] args) {
        PaymentContext context;

        context = new PaymentContext(new CreditCardPayment("1234-5678-9876-5432"));
        context.executePayment(100.0);

        context = new PaymentContext(new PayPalPayment("user@example.com"));
        context.executePayment(150.0);

        context = new PaymentContext(new BitcoinPayment("bitcoin-wallet-12345"));
        context.executePayment(200.0);
    }
}
```
