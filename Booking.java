package src;

public class Booking {
    int bookingId;
    int vehicleId;
    String serviceDate;
    String status;
    float estimatedCost;

    public Booking(int bookingId, int vehicleId, String serviceDate, String status, float estimatedCost) {
        this.bookingId = bookingId;
        this.vehicleId = vehicleId;
        this.serviceDate = serviceDate;
        this.status = status;
        this.estimatedCost = estimatedCost;
    }

    public String toString() {
        return bookingId + " - " + vehicleId + " - " + serviceDate + " - " + status + " - " + estimatedCost;
    }
}

