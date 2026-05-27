package org.example;

public class SavingsAccount extends BankAccount{
    private double interestRate;

    public SavingsAccount(String accountHolder, String accountNumber, double balance, double interestRate) {
        super(accountHolder, accountNumber, balance);
        this.interestRate = interestRate;
    }

    public void applyInterest(){
        double interest= getBalance() * interestRate;
        try{
            deposit(interest);
            System.out.println("Dobanda de "+ interest + "RON a fost adaugata");
        } catch (InvalidAmountException e) {
            System.out.println(e.getMessage());
        }
    }

    public double getInterestRate() {
        return interestRate;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" (Cont Economii, Dobândă: %.1f%%)", interestRate * 100);
    }
}
