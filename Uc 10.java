import java.util.*;
import java.util.stream.*;

// 🚉 Main Class
public class TrainUC10 {

    // 🔷 Abstract Bogie
    static abstract class Bogie {
        protected String id;
        protected int capacity;

        public Bogie(String id, int capacity) {
            this.id = id;
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }

        public abstract String getType();
    }

    // 🚍 Passenger Bogies
    static class Sleeper extends Bogie {
        public Sleeper(String id) { super(id, 72); }
        public String getType() { return "Sleeper"; }
    }

    static class ACChair extends Bogie {
        public ACChair(String id) { super(id, 60); }
        public String getType() { return "AC Chair"; }
    }

    static class FirstClass extends Bogie {
        public FirstClass(String id) { super(id, 40); }
        public String getType() { return "First Class"; }
    }

    // 🚛 Goods Bogies (ignored in seat counting)
    static class Rectangular extends Bogie {
        public Rectangular(String id) { super(id, 0); }
        public String getType() { return "Goods"; }
    }

    static class Cylindrical extends Bogie {
        public Cylindrical(String id) { super(id, 0); }
        public String getType() { return "Goods"; }
    }

    // 🚀 Main Method
    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        // Add Bogies
        bogies.add(new Sleeper("S1"));
        bogies.add(new ACChair("AC1"));
        bogies.add(new FirstClass("F1"));
        bogies.add(new Sleeper("S2"));
        bogies.add(new Rectangular("G1"));   // goods
        bogies.add(new Cylindrical("G2"));   // goods

        // 🔥 UC10: Total Seat Calculation using reduce()
        int totalSeats = bogies.stream()
                .filter(b -> !(b instanceof Rectangular || b instanceof Cylindrical)) // only passenger
                .map(b -> b.getCapacity())
                .reduce(0, (a, b) -> a + b);

        System.out.println("\n--- Total Seating Capacity ---");
        System.out.println("Total Seats in Train: " + totalSeats);
    }
}