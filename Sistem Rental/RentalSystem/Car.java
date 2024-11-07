// Car.java (Child Class)
public class Car extends Vehicle {
    private int numSeats;
    private String transmission;

    public Car(String vehicleId, String brand, String model, double rentalRate, 
               int numSeats, String transmission) {
        super(vehicleId, brand, model, rentalRate);
        this.numSeats = numSeats;
        this.transmission = transmission;
    }

    @Override
    public String getVehicleType() {
        return "Car";
    }

    public int getNumSeats() {
        return numSeats;
    }

    public String getTransmission() {
        return transmission;
    }

    @Override
    public String toString() {
        return super.toString() + String.format(" | %d seats, %s transmission", 
            numSeats, transmission);
    }
}
