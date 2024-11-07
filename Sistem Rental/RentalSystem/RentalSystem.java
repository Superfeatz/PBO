// RentalSystem.java
import java.util.ArrayList;
import java.util.Scanner;

public class RentalSystem {
    private ArrayList<Vehicle> vehicles;
    private ArrayList<Customer> customers;
    private ArrayList<Rental> rentals;
    private Scanner scanner;

    public RentalSystem() {
        vehicles = new ArrayList<>();
        customers = new ArrayList<>();
        rentals = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }

    public void addCustomer(Customer customer) {
        customers.add(customer);
    }

    public void rentVehicle(Vehicle vehicle, Customer customer, String rentalDate, int days) {
        if (vehicle.isAvailable()) {
            Rental rental = new Rental(vehicle, customer, rentalDate, days);
            rentals.add(rental);
            System.out.println("Rental successful!");
        } else {
            System.out.println("Vehicle is not available for rent.");
        }
    }

    public void displayAvailableVehicles() {
        System.out.println("\n=== Available Vehicles ===");
        int count = 1;
        for (Vehicle vehicle : vehicles) {
            if (vehicle.isAvailable()) {
                System.out.println(count + ". " + vehicle);
                count++;
            }
        }
    }

    public void displayRentals() {
        if (rentals.isEmpty()) {
            System.out.println("\nNo active rentals.");
            return;
        }
        System.out.println("\n=== Current Rentals ===");
        for (Rental rental : rentals) {
            System.out.println(rental);
        }
    }

    public void showMenu() {
        while (true) {
            System.out.println("\n=== Car Rental System ===");
            System.out.println("1. View Available Cars");
            System.out.println("2. Rent a Car");
            System.out.println("3. View Active Rentals");
            System.out.println("4. Exit");
            System.out.print("Choose option (1-4): ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    displayAvailableVehicles();
                    break;
                case 2:
                    processRental();
                    break;
                case 3:
                    displayRentals();
                    break;
                case 4:
                    System.out.println("Thank you for using Car Rental System!");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }

    private void processRental() {
        // Display available vehicles first
        displayAvailableVehicles();

        // Check if there are any available vehicles
        boolean hasAvailable = false;
        for (Vehicle v : vehicles) {
            if (v.isAvailable()) {
                hasAvailable = true;
                break;
            }
        }

        if (!hasAvailable) {
            System.out.println("Sorry, no vehicles are currently available.");
            return;
        }

        // Get car selection
        System.out.print("\nEnter the number of the car you want to rent: ");
        int carChoice = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Find selected vehicle
        Vehicle selectedVehicle = null;
        int count = 1;
        for (Vehicle v : vehicles) {
            if (v.isAvailable()) {
                if (count == carChoice) {
                    selectedVehicle = v;
                    break;
                }
                count++;
            }
        }

        if (selectedVehicle == null) {
            System.out.println("Invalid car selection.");
            return;
        }

        // Get customer details
        System.out.println("\nEnter customer details:");
        System.out.print("Name: ");
        String name = scanner.nextLine();
        System.out.print("Phone Number: ");
        String phone = scanner.nextLine();

        // Create customer
        String customerId = "CUST" + (customers.size() + 1);
        Customer customer = new Customer(customerId, name, phone);
        addCustomer(customer);

        // Get rental duration
        System.out.print("Enter number of days for rental: ");
        int days = scanner.nextInt();
        scanner.nextLine(); // consume newline

        // Create rental
        String currentDate = java.time.LocalDate.now().toString();
        rentVehicle(selectedVehicle, customer, currentDate, days);

        // Display rental details
        System.out.println("\nRental Details:");
        System.out.println("Vehicle: " + selectedVehicle);
        System.out.println("Customer: " + customer);
        System.out.println("Duration: " + days + " days");
        System.out.println("Total Cost: Rp" + (selectedVehicle.rentalRate * days));
    }

    public static void main(String[] args) {
        RentalSystem rentalSystem = new RentalSystem();

        // Initialize with some cars
        Car car1 = new Car("C001", "Toyota", "Avanza", 350000, 7, "Manual");
        Car car2 = new Car("C002", "Honda", "Civic", 500000, 5, "Automatic");
        Car car3 = new Car("C003", "Suzuki", "Ertiga", 400000, 7, "Manual");
        Car car4 = new Car("C004", "Toyota", "Innova", 450000, 8, "Automatic");
        Car car5 = new Car("C005", "Honda", "Brio", 300000, 5, "Manual");

        // Add cars to the system
        rentalSystem.addVehicle(car1);
        rentalSystem.addVehicle(car2);
        rentalSystem.addVehicle(car3);
        rentalSystem.addVehicle(car4);
        rentalSystem.addVehicle(car5);

        // Start the interactive menu
        rentalSystem.showMenu();
    }
}