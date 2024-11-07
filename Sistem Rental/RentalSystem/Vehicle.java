// Vehicle.java (Parent Class)
public abstract class Vehicle {
    protected String vehicleId;
    protected String brand;
    protected String model;
    protected double rentalRate;
    protected boolean isAvailable;

    public Vehicle(String vehicleId, String brand, String model, double rentalRate) {
        this.vehicleId = vehicleId;
        this.brand = brand;
        this.model = model;
        this.rentalRate = rentalRate;
        this.isAvailable = true;
    }

    public abstract String getVehicleType();

    public String getVehicleId() {
        return vehicleId;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return String.format("%s - %s %s (Rp%.2f per day) - %s",
            vehicleId, brand, model, rentalRate,
            isAvailable ? "Available" : "Rented");
    }
}
