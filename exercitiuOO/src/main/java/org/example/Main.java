package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    static void main(String[] args) {
        Garage garaj = new Garage(10);

        garaj.addVehicle(new Car("CAR-01", "Mercedes-Benz", 140.0, 12000, 4));
        garaj.addVehicle(new Car("CAR-02", "Mazda MX-5", 130.0, 4500, 2));

        garaj.addVehicle(new Motorcycle("MOTO-01", "Honda Africa Twin", 110.0, 7500, false));
        garaj.addVehicle(new Motorcycle("MOTO-02", "Ducati Panigale", 160.0, 1500, true));

        garaj.addVehicle(new Truck("TRUCK-01", "Scania V8", 85.0, 8000, 24.5));

        System.out.println("\nValidare ID Duplicat ");
        garaj.addVehicle(new Car("CAR-01", "Audi A4", 120.0, 0, 4));

        garaj.printAvailable();

        System.out.println("\nÎnchiriere");
        garaj.rentById("CAR-02");
        garaj.rentById("MOTO-01");

        System.out.println("\nDublă Închiriere");
        garaj.rentById("CAR-02");

        garaj.printAvailable();

        System.out.println("\n Estimare Preț ");
        garaj.printRentalEstimate("CAR-01", 5);   // Car: 50 * 5 zile + 10% (are 4 uși) = 275 EUR
        garaj.printRentalEstimate("MOTO-02", 3);  // Moto: 30 * 3 zile + 15 * 3 zile (are ataș) = 135 EUR
        garaj.printRentalEstimate("TRUCK-01", 2); // Truck: (80 + 0.02 * 24.5) * 2 zile = 160.98 EUR

        System.out.println("\nReturnare Vehicul");
        garaj.returnById("CAR-02", 600);

        garaj.printNeedsService();
    }
}
