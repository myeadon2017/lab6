package com.seed.transaction;

import com.seed.account.Account;

import com.seed.customer.Customer;

import com.seed.exception.InsufficientBalanceException;

import com.seed.exception.UnAuthorizedWithdrawTransactionException;

import com.seed.security.Security;

public class WithdrawTransaction extends Security implements Runnable{

	private int transactionId;

	/*

	* The account from which the amount must be drawn

	*/

	private Account account;

	/*

	* The customer who is doing the transaction

	*/

	private Customer customer;

	/*

	* The amount of withdrawal

	*/

	private double amount;

	/**

	* <h3>Description :</h3> The parameterized constructor is used

	* to initialize the object * @param transactionId the transaction id of the transaction * @param account the account on which the transaction is done * @param customer the customer who is doing the transaction * @param amount the amount of withdrawal

	*/

	public WithdrawTransaction(int transactionId,Account account,Customer customer,double amount){

	this.transactionId=transactionId;

	this.account=account;

	this.customer=customer;

	this.amount=amount;

	}

	public double withdraw(Account account,double amount) throws

	InsufficientBalanceException{

		if(account.getBalance()>=amount){

	account.setBalance(account.getBalance()-amount);
	}else{


		throw new InsufficientBalanceException();

		}

		return account.getBalance();

		}

		public void run() {

		try{

		//checking if the customer is authorized to withdraw

		authorization(account, customer);

		//withdrawing the amount after authorization

		double balance=withdraw(account, amount);

		//displaying the success message

		System.out.println(transactionId+" transaction"+ "completed!!! and the balance amount is "

		+balance);

		}catch(UnAuthorizedWithdrawTransactionException unAuthorizedWithdrawTransactionException){

		//displaying an appropriate message if the customer is

		//not authorized to do the transaction

		System.out.println(transactionId+" transaction "+ "failed!!! and "+

		unAuthorizedWithdrawTransactionException.getMessage());

		}catch(InsufficientBalanceException insufficientBalanceException){

		//display the error message for insufficient balance

		System.out.println(transactionId+" transaction "+

		"failed!!! and your account has insufficient"+

		"balance");

		}

		}

		}

