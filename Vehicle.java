package src;

public class Vehicle {
    int vehicleId;
    String ownerName;
    String model;
    float serviceCost;
    char fuelType;

    public Vehicle(int vehicleId, String ownerName, String model, float serviceCost, char fuelType) {
        this.vehicleId = vehicleId;
        this.ownerName = ownerName;
        this.model = model;
        this.serviceCost = serviceCost;
        this.fuelType = fuelType;
    }

    public String toString() {
        return vehicleId + " - " + ownerName + " - " + model + " - " + serviceCost + " - " + fuelType;
    }
}
