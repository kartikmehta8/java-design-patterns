---
layout: default
title: "Factory Method"
---

# Factory Method Design Pattern

## Overview

The **Factory Method** design pattern is a creational pattern that provides an interface for creating objects in a superclass, but allows subclasses to alter the type of objects that will be created. The Factory Method pattern is used to replace class constructors, promoting code reuse and simplifying the creation of objects.

## Structure

### 1. **Product (Notification)**

The interface or abstract class that defines the type of objects the factory method will create.

```java
public interface Notification {
    void notifyUser();
}
```

### 2. **Concrete Products (EmailNotification, SMSNotification)**

Concrete implementations of the `Notification` interface.

```java
public class EmailNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an email notification.");
    }
}

public class SMSNotification implements Notification {
    @Override
    public void notifyUser() {
        System.out.println("Sending an SMS notification.");
    }
}
```

### 3. **Creator (NotificationFactory)**

The abstract creator class declares the factory method that returns an object of type `Notification`. The creator may also define a default implementation for the factory method, which returns a default `Notification` object.

```java
public abstract class NotificationFactory {
    public abstract Notification createNotification();

    public void sendNotification() {
        Notification notification = createNotification();
        notification.notifyUser();
    }
}
```

### 4. **Concrete Creators (EmailNotificationFactory, SMSNotificationFactory)**

Concrete implementations of the creator class. These classes override the factory method to return specific types of `Notification`.

```java
public class EmailNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new EmailNotification();
    }
}

public class SMSNotificationFactory extends NotificationFactory {
    @Override
    public Notification createNotification() {
        return new SMSNotification();
    }
}
```

### 5. **Client Code**

The client code uses the factory classes to create and send notifications without needing to know the details of the concrete implementations.

```java
public class FactoryMethodPatternExample {
    public static void main(String[] args) {
        NotificationFactory emailFactory = new EmailNotificationFactory();
        emailFactory.sendNotification();

        NotificationFactory smsFactory = new SMSNotificationFactory();
        smsFactory.sendNotification();
    }
}
```

## Usage

### When to Use

- When a class cannot anticipate the type of objects it needs to create.
- When a class wants its subclasses to specify the objects it creates.
- When you want to delegate the responsibility of object instantiation to derived classes, promoting loose coupling.

### Where to Use

- In frameworks where library code needs to instantiate user-defined objects.
- In systems where you need to manage or handle different types of objects in a uniform way, but the specific type of object is determined at runtime.

## Advantages

- **Single Responsibility Principle**: The Factory Method pattern allows the creation code to be separated from the code that uses the objects, adhering to the single responsibility principle.
- **Encapsulation of Object Creation**: It encapsulates the creation details of the objects, making the system more modular and easier to extend.
- **Ease of Extension**: New types of products can be introduced by adding new concrete creators without modifying existing code.

## Disadvantages

- **Increased Complexity**: The pattern may introduce unnecessary complexity by requiring a new subclass for each product type.
- **Limited Flexibility**: The factory method pattern relies heavily on inheritance, which may limit its flexibility compared to other patterns like dependency injection.

## Conclusion

The Factory Method pattern is a powerful design pattern that provides a way to delegate the responsibility of object instantiation to subclasses. It helps in creating a more modular and extendable codebase while adhering to clean coding principles. However, it should be used judiciously, as it can increase the complexity of the code if overused.
