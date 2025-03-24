package com.raxrot.bankapp;

import java.util.HashMap;
import java.util.Map;

public class AccountService {

    private Map<Long,Account> accounts=new HashMap<>();

    public Account createAccount(long accountNumber,String holderName,double balance) {
        if(accounts.containsKey(accountNumber)){
            throw new IllegalArgumentException("Account number "+accountNumber+" already exists");
        }

        Account account = new Account(accountNumber,holderName,balance);
        accounts.put(accountNumber,account);
        return account;
    }

    public Account updateAccount(long accountNumber,String holderName) {
        Account account = accounts.get(accountNumber);
        if(account == null){
            throw new AccountNotFoundException("Account number "+accountNumber+" does not exist");
        }
        account.setHolderName(holderName);
        return account;
    }

    public Account getAccount(long accountNumber) {
        Account account = accounts.get(accountNumber);
        if(account == null){
            throw new AccountNotFoundException("Account number "+accountNumber+" does not exist");
        }
        return account;
    }

    public void removeAccount(long accountNumber) {
        Account account = accounts.get(accountNumber);
        if(account == null){
            throw new AccountNotFoundException("Account number "+accountNumber+" does not exist");
        }
        accounts.remove(accountNumber);
    }

    public void deposit(long accountNumber,double amount) {
        Account account = accounts.get(accountNumber);
        if(account == null){
            throw new AccountNotFoundException("Account number "+accountNumber+" does not exist");
        }
        if(amount <= 0){
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        account.setBalance(account.getBalance()+amount);
    }

    public void withdraw(long accountNumber,double amount) {
        Account account = accounts.get(accountNumber);
        if(account == null){
            throw new AccountNotFoundException("Account number "+accountNumber+" does not exist");
        }
        if(amount <= 0){
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        if (amount>account.getBalance()){
            throw new IllegalArgumentException("Insufficient balance");
        }
        account.setBalance(account.getBalance()-amount);
    }

    public void transferMoney(long fromAccountNumber,long toAccountNumber,double amount) {
        Account fromAccount = accounts.get(fromAccountNumber);
        Account toAccount = accounts.get(toAccountNumber);
        if(fromAccount == null || toAccount == null){
            throw new AccountNotFoundException("Wrong account number");
        }
        if(amount <= 0){
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        if (amount>fromAccount.getBalance()){
            throw new IllegalArgumentException("Insufficient balance");
        }
        fromAccount.setBalance(fromAccount.getBalance()-amount);
        toAccount.setBalance(toAccount.getBalance()+amount);
    }
}
