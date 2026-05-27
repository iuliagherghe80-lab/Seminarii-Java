package org.example;

public class BankAccount {
    private String accountHolder;
    private String accountNumber;
    private double balance;

    public BankAccount(String accountHolder, String accountNumber, double balance){
        this.accountHolder=accountHolder;
        this.accountNumber=accountNumber;
        this.balance=balance;
    }

    public void deposit(double amount) throws InvalidAmountException{
        if(amount <= 0 ){
            throw new InvalidAmountException("Suma depusa trebuie sa fie mai mare decat 0!");
        }
        this.balance += amount;
        System.out.println("S-au depus "+amount + "RON");
    }

    public void withdraw(double amount) throws InvalidAmountException, InsufficientFundsException{
        if(amount <=0 ){
            throw new InvalidAmountException("Suma retrasa trebuie sa fie mai mare decat 0");
        }
        if(amount > this.balance){
            throw new InsufficientFundsException("Fonduri insuficiente");
        }
        this.balance -= amount;
        System.out.println("S-au retras "+amount + "RON");
    }

    public String getAccountHolder() {
        return accountHolder;
    }
    public String getAccountNumber() {
        return accountNumber;
    }
    public double getBalance() {
        return balance;
    }

    @Override
    public String toString() {
        return String.format("Cont [%s] | Titular: %s | Sold: %.2f RON", accountNumber, accountHolder, balance);
    }
}
