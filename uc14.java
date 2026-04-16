import java.util.*;

// Custom Exception
class InvalidBogieCapacityException extends Exception {
    public InvalidBogieCapacityException(String message) {
        super(message);
    }
}

// Passenger Bogie Class
class PassengerBogie {
    private String bogieId;
    private int capacity;

    public PassengerBogie(String bogieId, int capacity)
            throws InvalidBogieCapacityException {

        if (capacity <= 0) {
            throw new InvalidBogieCapacityException(
                    "Invalid capacity for Bogie " + bogieId +
                            ". Capacity must be greater than 0."
            );
        }

        this.bogieId = bogieId;
        this.capacity = capacity;
    }

    public String getBogieId() {
        return bogieId;
    }

    public int getCapacity() {
        return capacity;
    }
}

// Train Class
class Train {
    private List<PassengerBogie> bogies = new ArrayList<>();

    public void addBogie(PassengerBogie bogie) {
        bogies.add(bogie);
        System.out.println("Bogie " + bogie.getBogieId() + " added successfully.");
    }

    public void displayBogies() {
        System.out.println("\nValid Bogies in Train:");
        for (PassengerBogie b : bogies) {
            System.out.println("ID: " + b.getBogieId() +
                    ", Capacity: " + b.getCapacity());
        }
    }
}

// Main Class
public class Main {
    public static void main(String[] args) {

        Train train = new Train();

        // Input Data (valid + invalid)
        String[] ids = {"B1", "B2", "B3", "B4"};
        int[] capacities = {50, -10, 0, 80};

        for (int i = 0; i < ids.length; i++) {
            try {
                PassengerBogie bogie = new PassengerBogie(ids[i], capacities[i]);
                train.addBogie(bogie);
            } catch (InvalidBogieCapacityException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        train.displayBogies();
    }
}