import java.util.Scanner;

class Vehicle {
    protected double dailyRate;

    Vehicle(double dailyRate) {
        this.dailyRate = dailyRate;
    }

    public double calculateRentalCharge(int rentalDays) {
        return dailyRate * rentalDays;
    }

    public String getVehicleType() {
        return "Vehicle";
    }
}

class Car extends Vehicle {
    Car() {
        super(1500.0);
    }

    @Override
    public String getVehicleType() {
        return "Car";
    }
}

class Bike extends Vehicle {
    Bike() {
        super(600.0);
    }

    @Override
    public String getVehicleType() {
        return "Bike";
    }
}

class Truck extends Vehicle {
    Truck() {
        super(3000.0);
    }

    @Override
    public String getVehicleType() {
        return "Truck";
    }
}

public class VehicleRentalSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int vehicleType = sc.nextInt();
        int rentalDays = sc.nextInt();

        Vehicle vehicle;
        switch (vehicleType) {
            case 1:
                vehicle = new Car();
                break;
            case 2:
                vehicle = new Bike();
                break;
            default:
                vehicle = new Truck();
        }

        System.out.println("Vehicle Type: " + vehicle.getVehicleType());
        System.out.printf("Rental Charge: %.2f%n",
                vehicle.calculateRentalCharge(rentalDays));

        sc.close();
    }
}
