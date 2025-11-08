💳 Transaction Engine

A Spring Boot–based digital wallet system that helps users send and receive money, check balances, and track all transactions securely. Built with Java, MySQL, and Hibernate, it ensures fast performance, reliable data handling, and strong security.

🚀 Features 🔐 User Login & Roles

Secure user authentication system.

Supports multiple roles (Admin, User).

💰 Wallet System

Each user gets a dedicated wallet.

View wallet type, balance, and transaction limits.

🔄 Transactions

Perform credit (add money) and debit (spend money) operations.

Balance validation before every transaction.

Wallet balance updates automatically.

🧾 Transaction Records

Maintains full history of all wallet transactions.

Helps in audits, reporting, and analysis.

⚙️ Error Handling

Clear error messages for invalid data or insufficient balance.

Global exception handling for smooth user experience.

🗃️ Database

Secure data storage using MySQL.

Integrated with Hibernate/JPA for ORM support.

🧩 DTO (Data Transfer Objects)

Ensures safe and clean data sharing between layers (Entity → Service → Controller).

🏗️ Tech Stack Purpose Technology Backend Spring Boot Database MySQL ORM Hibernate / JPA Language Java 17+ Build Tool Maven IDE IntelliJ IDEA / Eclipse API Testing Postman / cURL
