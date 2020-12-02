package com.seed.main;

import com.seed.account.Account;

import com.seed.customer.Customer;

import com.seed.transaction.DepositTransaction;

import com.seed.transaction.WithdrawTransaction;

public class SeedBank {


public static void main(String[] args) {

//creating the object of the first customer

Customer firstCustomer=new Customer(1001,"Raj");

//creating the object of the first account

Account firstAccount=new Account(2001,firstCustomer,20000);

//creating the second account object

Customer secondCustomer=new Customer(1002,"Narayan");

//creating the second account object

Account secondAccount=new

Account(2001,secondCustomer,20000);

//creating the depositing transaction thread

DepositTransaction firstDeposit=new

DepositTransaction(9001, secondAccount, 5001, 4000);

firstDeposit.start();

//creating the depositing transaction thread

DepositTransaction secondDeposit=new

DepositTransaction(9002, firstAccount, 5002, 7000);

secondDeposit.start();

WithdrawTransaction secondWithdrawTransaction=new WithdrawTransaction(9004,firstAccount, secondCustomer,500);

Thread secondWithdraw=new Thread(secondWithdrawTransaction);

secondWithdraw.start();// this transaction must fail

WithdrawTransaction firstWithdrawTransaction=new WithdrawTransaction(9003,firstAccount, firstCustomer, 500); Thread firstWithdrawal=new

Thread(firstWithdrawTransaction);

firstWithdrawal.start();

}

}
