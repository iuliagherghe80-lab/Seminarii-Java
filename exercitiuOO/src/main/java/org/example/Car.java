package org.example;
import java.util.Objects;

public class Car extends Vehicle{
    private int doors;

    public Car(String id, String brand, double speed, int mileage, int doors)
    {
        super(id, brand, speed, mileage);
        this.doors=doors;
    }

    @Override
    public boolean needsService() {
        return getMileage()>=10000;
    }

    @Override
    public double rentalPrice(int days) {
        double price = 50*days;
        if(this.doors >= 4)
        {
            price += 0.1*price;
        }
        return price;
    }

    @Override
    public void move() {
        System.out.println("Mașina " + getBrand() + " se deplasează pe autostradă cu viteza de " + getSpeed() + " km/h.");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car masina = (Car) o;
        return Double.compare(masina.getSpeed(), getSpeed()) == 0 &&
                Objects.equals(getBrand(), masina.getBrand());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBrand(), getSpeed());
    }
}
