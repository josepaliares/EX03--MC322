# Event Management System – Marketplace & JavaFX Extension

This project builds upon the previous Event Management System developed for the **MC322 - Object-Oriented Programming** course at **UNICAMP**, by introducing a **ticket marketplace** and a **graphical user interface (GUI)** using **JavaFX**.

## Key Concepts

- **Object Reuse:** Extend and reuse existing Lab 2 classes for new functionalities like resale.
- **Composition & Responsibility:** Apply proper object responsibilities and use composition when modeling new behaviors (e.g., marketplace offers).
- **Encapsulation:** Keep internal data safe and interact only through well-defined methods.
- **Polymorphism:** Use interfaces and abstract classes to interact with multiple object types generically.
- **Layered Architecture:** Maintain a clear separation between business logic and the GUI.
- **JavaFX GUI:** Use the JavaFX framework with FXML to build a responsive and modular user interface.
- **Exception Handling:** Propagate and handle exceptions in both backend and frontend layers.
- **Unit Testing:** Ensure correctness of marketplace and client interactions through unit tests.

## New Features

### 🎟 Marketplace

A system that allows clients to **resell tickets** to others:

- **OfertaIngresso:** Represents a ticket listing with the seller and requested price.
- **Marketplace:** 
  - Stores all ticket offers.
  - Handles listing, purchasing, and commission management.
- **Client Enhancements:**
  - Sell a ticket via `oferecerIngressoParaVenda(...)`.
  - Buy a ticket via `comprarIngressoNoMarketplace(...)`.
  - Manages balance (`saldo`) for realistic transactions.

### 🖥 GUI with JavaFX

A user-friendly JavaFX interface to:

- Display events and their details.
- Log in as a client and view tickets.
- Buy original tickets from the event.
- List or purchase tickets in the marketplace.
- Display errors (e.g., insufficient balance, ticket not found) using alerts.

## Running

To run the GUI:
```bash
./gradlew run
```

To run tests:
```bash
./gradlew test
```