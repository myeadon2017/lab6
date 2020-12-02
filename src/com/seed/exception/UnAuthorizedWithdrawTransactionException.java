package com.seed.exception;

public class UnAuthorizedWithdrawTransactionException extends

Exception {

public UnAuthorizedWithdrawTransactionException() {

//calling the super class constructor

super("The user is unauthorized for the withdrawal");

}

}