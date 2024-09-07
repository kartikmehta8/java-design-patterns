---
layout: default
title: "Simple Factory"
---

# Simple Factory Design Pattern

## Overview

The **Simple Factory Design Pattern** is a creational design pattern that centralizes the creation of objects. It provides a factory class that encapsulates the logic of creating objects and returns an instance of the desired class. This pattern is used to decouple the client code from the specific implementation details of object creation.

## Structure

### 1. **Product (Vehicle)**

The product is the interface or abstract class that all concrete products (like `Car` and `Bike`) must implement.

### 2. **Concrete Products (Car, Bike)**

These are the concrete implementations of the `Vehicle` interface. Each concrete class implements the specific behavior for that type of product.

### 3. **Simple Factory (VehicleFactory)**

The simple factory is responsible for creating instances of the concrete products. It contains a method (`createVehicle`) that takes a string or identifier and returns the corresponding object.

### 4. **Client Code**

The client code interacts with the factory to create objects without worrying about how the objects are instantiated.

## Usage

### When to Use

- When the **object creation logic is complex** and should be encapsulated from the client.
- When you need a centralized place to create objects, instead of duplicating object creation logic in the client code.
- When the client should not be exposed to the specific classes of the objects it creates.
- When you have a fixed set of object types, but don't expect to add new ones frequently.

### Where to Use

- **Vehicle Factory**: Creating different types of vehicles (car, bike, etc.) based on user input.
- **Payment Processing**: Creating different payment objects (credit card, PayPal, bank transfer) based on payment type.
- **File Handling**: Creating different types of file readers (PDF reader, CSV reader, etc.) depending on the file type.

## Advantages

- **Encapsulation of Object Creation**: The factory hides the details of object creation, making it easier for the client to use the objects without knowing how they are instantiated.
- **Centralized Object Creation**: The factory provides a single place to manage the creation of all related objects, which makes the code more maintainable and flexible.
- **Reduces Code Duplication**: By using the factory, you eliminate the need to write the same object creation logic multiple times.
- **Simplifies Client Code**: The client code doesn't need to know about the specific classes or how to instantiate them. It only needs to call the factory.

## Disadvantages

- **Not Open for Extension**: Adding new types of objects may require changing the factory class, which violates the Open-Closed Principle (OCP) because the factory is not easily extensible without modification.
- **Single Responsibility Violation**: The factory might become too large if it's responsible for creating many types of objects, which violates the Single Responsibility Principle (SRP).

## Example Usage

Here’s an example of how the Simple Factory pattern can be used:

```java
public class SimpleFactoryExample {
    public static void main(String[] args) {
        Vehicle car = VehicleFactory.createVehicle("car");
        car.start();
        car.stop();

        Vehicle bike = VehicleFactory.createVehicle("bike");
        bike.start();
        bike.stop();
    }
}
```

## Conclusion

The Simple Factory pattern is an effective design pattern for centralizing object creation and separating the client code from the object creation process. While it provides flexibility in object creation, it can become difficult to manage when adding new object types, as it is not easily extensible. Overall, this pattern is useful in situations where you have a fixed set of related objects that need to be created.
