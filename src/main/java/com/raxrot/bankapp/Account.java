package com.raxrot.bankapp;

public class Account {
    private long accountNumber;
    private String holderName;
    private double balance;

    public Account(long accountNumber, String holderName, double balance) {
        this.accountNumber = accountNumber;
        this.holderName = holderName;
        this.balance = balance;
    }

    public void setAccountNumber(long accountNumber) {
        this.accountNumber = accountNumber;
    }
    public void setHolderName(String holderName) {
        this.holderName = holderName;
    }
    public void setBalance(double balance) {
        this.balance = balance;
    }
    public long getAccountNumber() {
        return accountNumber;
    }
    public String getHolderName() {
        return holderName;
    }
    public double getBalance() {
        return balance;
    }
}
