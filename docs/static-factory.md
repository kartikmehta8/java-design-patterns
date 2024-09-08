---
layout: default
title: "Singleton Pattern"
---

# Static Factory Design Pattern

## Overview

The **Static Factory Design Pattern** is a creational design pattern that provides a static method to create objects. Instead of using constructors, the static factory method returns instances based on provided parameters, giving more control over the object creation process. Unlike traditional constructors, static factory methods can return pre-existing objects, cache instances, or return different subtypes based on input.

## Structure

### 1. **Product (User)**

The `User` interface defines common behavior for all types of users.

### 2. **Concrete Products (AdminUser, RegularUser)**

The concrete implementations of the `User` interface. Each class implements specific behaviors related to their user type.

### 3. **Static Factory (UserFactory)**

The factory class contains a static method (`createUser`) that determines which concrete class to instantiate based on the input provided (e.g., "admin" or "regular").

### 4. **Client Code**

The client uses the static factory method to create user objects without knowing the details of how objects are instantiated.

## Usage

### When to Use

- When you want **more control** over how objects are created, beyond what is possible with constructors.
- When you need a **better naming convention** than what constructors provide.
- When the logic for creating objects becomes too complex for constructors.
- When you want to return different **subtypes** of a class based on input or conditions.

### Where to Use

- **User Roles**: Creating different user types based on roles (e.g., `AdminUser`, `RegularUser`).
- **Payment Processors**: Creating different payment types (e.g., `CreditCardPayment`, `PayPalPayment`).
- **File Parsers**: Returning different file parsers based on file types (e.g., `CsvParser`, `XmlParser`).

## Advantages

- **Encapsulation of Object Creation**: The factory method hides the object creation logic from the client, making the client code simpler and easier to maintain.
- **Better Naming than Constructors**: Static factory methods can have meaningful names (e.g., `createUser()`), which improves the readability and intent of the code compared to constructors.
- **Flexible Return Types**: A static factory method can return subtypes of the specified return type, allowing flexibility in object creation.
- **Controlled Object Creation**: The factory method provides control over object creation, which can allow caching, pre-initialization, or limiting the number of instances.

## Disadvantages

- **Cannot be Inherited**: A class that only has static factory methods cannot be subclassed, which may be restrictive in certain situations.
- **Not Always Intuitive**: The use of static factory methods can sometimes be less intuitive than constructors, especially for developers unfamiliar with the pattern.
- **Lack of New Instances**: Unlike constructors, static factory methods may return existing instances rather than new objects, which can sometimes cause confusion.

## Example Usage

Here’s an example of how the Static Factory pattern can be used:

```java
public class StaticFactoryExample {
    public static void main(String[] args) {
        // Create an Admin User using the static factory method
        User admin = UserFactory.createUser("admin");
        admin.displayRole();

        // Create a Regular User using the static factory method
        User regular = UserFactory.createUser("regular");
        regular.displayRole();
    }
}
```

## Conclusion

The Static Factory Design Pattern provides a flexible and powerful way to create objects. By using static methods instead of constructors, it improves control over object creation, allows for better naming conventions, and enhances flexibility in returning different subtypes. While it may introduce some restrictions, such as the inability to subclass, the benefits make it a valuable pattern for managing complex object creation.
