package org.example;

public class Garage {
    private Vehicle[] fleet;
    private int size;

    public Garage(int capacity) {
        this.fleet = new Vehicle[capacity];
        this.size = 0;
    }

    public boolean addVehicle(Vehicle v){
        if (size >= fleet.length) {
            System.out.println("Eroare: Garajul este plin! Nu se poate adăuga vehiculul " + v.getId());
            return false;
        }
        if (findById(v.getId()) != null) {
            System.out.println("Eroare: Un vehicul cu ID-ul " + v.getId() + " există deja în sistem!");
            return false;
        }
        fleet[size] = v;
        size++;
        System.out.println("Vehiculul " + v.getId() + " (" + v.getBrand() + ") a fost adăugat cu succes.");
        return true;
    }

    public Vehicle findById(String id) {
        for(int i=0; i<size; i++)
        {
            if (fleet[i].getId().equalsIgnoreCase(id)) {
                return fleet[i];
            }
        }
        return null;
    }

    public void rentById(String id) {
        Vehicle v = findById(id);
        if (v != null) {
            try {
                v.rent();
                System.out.println("Succes: Vehiculul " + id + " a fost închiriat.");
            } catch (IllegalStateException e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Eroare: Vehiculul cu ID-ul " + id + " nu există în garaj.");
        }
    }

    public void returnById(String id, int drivenKm) {
        Vehicle v = findById(id);
        if (v != null) {
            try {
                v.returnVehicle(drivenKm);
            } catch (Exception e) {
                System.out.println(e.getMessage());
            }
        } else {
            System.out.println("Eroare: Vehiculul cu ID-ul " + id + " nu există în garaj.");
        }
    }

    public void printAvailable() {
        System.out.println("\nVehicule care pot fi rented");
        boolean gasit = false;
        for (int i = 0; i < size; i++) {
            if (!fleet[i].isRented()) {
                System.out.println(fleet[i]);
                gasit = true;
            }
        }
        if (!gasit) System.out.println("Nu există vehicule disponibile.");
    }

    public void printNeedsService() {
        System.out.println("\nVehicule care au nevoie de service");
        boolean gasit = false;
        for (int i = 0; i < size; i++) {
            if (fleet[i].needsService()) {
                System.out.println(fleet[i] + " SERVICE");
                gasit = true;
            }
        }
        if (!gasit) System.out.println("Toate vehiculele sunt în stare tehnică bună.");
    }

    public void printRentalEstimate(String id, int days) {
        Vehicle v = findById(id);
        if (v != null) {
            double pret = v.rentalPrice(days);
            System.out.println("Estimare preț pentru " + id + " (" + days + " zile): " + pret + " RON");
        } else {
            System.out.println("Eroare: Vehiculul cu ID-ul " + id + " nu a fost găsit pentru estimare.");
        }
    }
}
