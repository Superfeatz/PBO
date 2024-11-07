// Rental.java
public class Rental {
    private Vehicle vehicle;
    private Customer customer;
    private String rentalDate;
    private int daysRented;

    public Rental(Vehicle vehicle, Customer customer, String rentalDate, int daysRented) {
        this.vehicle = vehicle;
        this.customer = customer;
        this.rentalDate = rentalDate;
        this.daysRented = daysRented;
        vehicle.setAvailable(false);
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public Customer getCustomer() {
        return customer;
    }

    @Override
    public String toString() {
        return String.format("Rental: %s rented by %s on %s for %d days", 
            vehicle.getVehicleId(), customer.getName(), rentalDate, daysRented);
    }
}