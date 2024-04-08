package com.day02p01;
//BankAccount class definition
class BankAccount {
 // Fields
 private int accNo;
 private String custName;
 private String accType;
 private float balance;

 // Constructor
 public BankAccount(int accNo, String custName, String accType, float balance) throws NegativeAmount, LowBalanceException {
     this.accNo = accNo;
     this.custName = custName;
     this.accType = accType;
     
     // Check if balance is negative
     if (balance < 0) {
         throw new NegativeAmount();
     }

     // Check if balance is less than required minimum based on account type
     if ((accType.equalsIgnoreCase("saving") && balance < 1000) ||
         (accType.equalsIgnoreCase("current") && balance < 5000)) {
         throw new LowBalanceException();
     }

     this.balance = balance;
 }

 // Method to deposit amount
 public void deposit(float amt) throws NegativeAmount {
     // Check if deposit amount is negative
     if (amt < 0) {
         throw new NegativeAmount();
     }
     balance += amt; // Add amount to balance
 }

 // Method to get current balance
 public float getBalance() throws LowBalanceException {
     // Check if balance is below minimum required balance for savings account
     if (accType.equalsIgnoreCase("saving") && balance < 1000) {
         throw new LowBalanceException();
     }
     // Check if balance is below minimum required balance for current account
     if (accType.equalsIgnoreCase("current") && balance < 5000) {
         throw new LowBalanceException();
     }
     return balance;
 }
}
