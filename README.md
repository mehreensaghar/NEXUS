🏦 Nexus Banking App
A secure and efficient banking application developed using Java Swing, JFrame, and MySQL, designed to offer seamless online banking services including account management, fund transfers, bill payments, and ATM transactions.

🚀 Features
User Authentication

Secure login with 4-digit PIN

New user registration and profile management

Send Money

Transfer funds to other accounts with payment purpose selection

OTP verification via email for transaction security

Bill Payments & Top-Ups

Pay bills and recharge accounts easily

ATM Transactions

Deposit, withdraw, fast cash, balance inquiry, and mini statement options

Settings & Security

Change PIN, enable fingerprint sensor (planned feature), log out

Feedback System

Star ratings and user feedback collection for service improvement


🛠️ Tech Stack
Frontend: Java Swing, JFrame

Backend: Java Programming Language

Database: MySQL

Security: OTP verification, encrypted data handling

Environment: Compatible with Windows/Linux (minimum 2GB RAM, dual-core CPU)


⚙️ How to Run
Clone Repository

bash
Copy
Edit
git clone https://github.com/username/nexus-banking-app.git
cd nexus-banking-app
Setup Database

Import nexus_db.sql into MySQL server

Update DB credentials in DatabaseConnection.java

Run Application

Open project in any Java IDE (IntelliJ, Eclipse, NetBeans)

Compile and run Main.java



✅ Testing
The system has been tested for:

Successful login with valid credentials

Prevention of invalid logins

Balance updates after every transaction

Prevention of transactions exceeding balance

Database updates for password changes

📌 Future Enhancements
Mobile version for Android & iOS

AI-based fraud detection system

Fingerprint authentication for secure login

