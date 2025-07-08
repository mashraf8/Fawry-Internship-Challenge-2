# Bookstore System Analysis and Design

### **1. Applied SOLID Principles**

#### Single Responsibility Principle
- **Definition:** A class should have only one reason to change.
- **Application:**
    - `Book`: Core data and behavior.
    - Subclasses (`PaperBook`, `EBook`, `ShowcaseBook`): Handle specific sale behaviors.
    - `Inventory`: Manages book storage.
    - `ShippingService` & `MailService`: Handle delivery logic.
    - `Bookstore`: Coordinates the sale process.

#### Open/Closed Principle
- **Definition:** Classes should be open for extension, closed for modification.
- **Application:** New book types (e.g`AudioBook`) can be added by extending `Book` and overriding `processSale()` without altering existing code.

#### Dependency Inversion Principle
- **Definition:** High-level modules depend on abstractions, not concrete implementations.
- **Application:**
    - `PaperBook` uses `IShippingService`.
    - `EBook` uses `IMailService`.
    - Enables easy replacement and decoupling.

### **2. Applied Design Pattern**

#### Strategy Pattern
- **Definition:** Encapsulates interchangeable algorithms or behaviors.
- **Application:**
    - `ShippingService` and `MailService` are passed to books to handle delivery.
    - `processSale()` delegates behavior via injected strategy:
        - `PaperBook`: calls `shippingService.send()`.
        - `EBook`: calls `mailService.send()`.

### **3. Choice of Data Structures**

- **Why `Map<String, Book>` in `Inventory`?**
    - Fast lookup by ISBN (O(1)).
    - Prevents duplicates, simplifies updates/removals.

- **Why `LinkedHashMap` over `HashMap`?**
    - Maintains insertion order for consistent listing/removal.

### **4. Output**

![Output Image](image/output.png)