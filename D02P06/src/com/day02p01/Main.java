package com.day02p01;

import java.util.Scanner;

public class Main {
	 public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);

	        try {
	            System.out.println("Enter account number:");
	            int accNo = scanner.nextInt();
	            scanner.nextLine(); // Consume newline character

	            System.out.println("Enter customer name:");
	            String custName = scanner.nextLine();

	            System.out.println("Enter account type (Saving/Current):");
	            String accType = scanner.nextLine();

	            System.out.println("Enter initial balance:");
	            float initialBalance = scanner.nextFloat();

	            // Create BankAccount object
	            BankAccount account = new BankAccount(accNo, custName, accType, initialBalance);

//	            // Deposit
//	            System.out.println("Enter amount to deposit:");
//	            float depositAmount = scanner.nextFloat();
//	            account.deposit(depositAmount);
//	            System.out.println("Deposit successful.");

	            // Get balance
	            System.out.println("Current balance: " + account.getBalance());
	        } catch (NegativeAmount e) {
	            System.out.println("NegativeAmount: Cannot process negative amounts.");
	        } catch (LowBalanceException e) {
	            System.out.println("LowBalance: Balance is below minimum required amount.");
	        }
	        scanner.close();
	    }
	}