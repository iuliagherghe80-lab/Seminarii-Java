package org.example;

public class Motorcycle extends Vehicle{
    private boolean hasSidecar;

    public Motorcycle(String id, String brand, double speed, int mileage, boolean hasSidecar)
    {
        super(id, brand, speed, mileage);
        this.hasSidecar=hasSidecar;
    }

    @Override
    public boolean needsService() {
        return getMileage()>=6000;
    }

    @Override
    public double rentalPrice(int days) {
        double price= 30 * days;
        if(hasSidecar){
            price += 15*days;
        }
        return price;
    }

    @Override
    public void move() {
        System.out.println("Motocicleta " + getBrand() + " se strecoară prin trafic cu viteza de " + getSpeed() + " km/h.");
    }
}
