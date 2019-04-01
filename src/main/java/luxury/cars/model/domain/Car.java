package luxury.cars.model.domain;

import java.util.Date;

public class Car {
    public String make;
    public String model;
    public Integer year;
    public Date dateOfPurchase;

    public Car(String make, String model, Integer year) {
        this.make = make;
        this.model = model;
        this.year = year;
        this.dateOfPurchase = new Date();
    }
}
