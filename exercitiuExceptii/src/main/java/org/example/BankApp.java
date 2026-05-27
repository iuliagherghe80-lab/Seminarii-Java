package org.example;

public class BankApp {
    public static void main(String[] args){
        BankAccount contCurent = new BankAccount("Iulia Gherghe", "RO12BREL0001", 500.0);
        SavingsAccount contEconomii = new SavingsAccount("Andrei Popescu", "RO99INGB0002", 2000.0, 0.05); // 5% dobândă

        System.out.println(contCurent);
        System.out.println(contEconomii);

        try {
            contCurent.deposit(200);
            contCurent.withdraw(150);
            System.out.println(contCurent);
        } catch (Exception e) {
            System.out.println("Tranzacțiile sunt invalide.");
        }

        try {
            contCurent.deposit(-50);
        } catch (InvalidAmountException e) {
            System.out.println("Am prins excepția: " + e.getMessage());
        }

        try {
            contCurent.withdraw(1000);
        } catch (InvalidAmountException e) {
            System.out.println("Eroare de sumă: " + e.getMessage());
        } catch (InsufficientFundsException e) {
            System.out.println("Am prins excepția: " + e.getMessage());
        }

        System.out.println("Înainte: " + contEconomii);
        contEconomii.applyInterest();
        System.out.println("După: " + contEconomii);
    }
}
