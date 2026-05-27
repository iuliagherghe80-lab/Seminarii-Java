package org.example;

public abstract class Vehicle {
    private String id;
    private int mileage;
    private boolean rented;
    private String brand;
    private double speed;

    public Vehicle(String id, String brand, double speed, int mileage){
        this.id = id;
        this.mileage = mileage;
        this.rented = false;
        this.brand = brand;
        this.speed = speed;
    }

    public void rent(){
        if(this.rented)
        {
            throw new IllegalStateException("Eroare: Vehiculul cu ID-ul " + id + " este deja închiriat!");
        }
        this.rented= true;
    }

    public void returnVehicle(int drivenKm){
        if(!this.rented) {
            throw new IllegalStateException("Eroare: Vehiculul cu ID-ul " + id + " nu este închiriat!");
        }
        if(drivenKm<0){
            throw new IllegalStateException("Eroare: Numărul de kilometri parcurși trebuie să fie mai mare decât 0!");
        }
        this.mileage += drivenKm;
        rented = false;
    }

    public abstract boolean needsService();
    public abstract double rentalPrice(int days);

    public abstract void move();

    public String getId() { return id; }

    public String getBrand() { return brand; }
    public void setBrand(String brand) { this.brand = brand; }

    public double getSpeed() { return speed; }
    public void setSpeed(double speed) { this.speed = speed; }

    public int getMileage() { return mileage; }
    public void setMileage(int mileage) { this.mileage = mileage; }

    public boolean isRented() { return rented; }
    public void setRented(boolean rented) { this.rented = rented; }

    @Override
    public String toString() {
        return String.format("[%s] %s (Viteză: %.1f km/h, Kilometraj: %d km, Închiriat: %s)",
                id, brand, speed, mileage, rented ? "DA" : "NU");
    }
}


