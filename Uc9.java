import java.util.*;
import java.util.stream.*;

// 🚉 Main Class
public class TrainUC9 {

    // 🔷 Abstract Bogie
    static abstract class Bogie {
        protected String id;
        protected int capacity;

        public Bogie(String id, int capacity) {
            this.id = id;
            this.capacity = capacity;
        }

        public abstract String getType();

        @Override
        public String toString() {
            return getType() + " [ID=" + id + ", Cap=" + capacity + "]";
        }
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

    // 🚛 Goods Bogies
    static class Rectangular extends Bogie {
        public Rectangular(String id) { super(id, 100); }
        public String getType() { return "Goods - Rectangular"; }
    }

    static class Cylindrical extends Bogie {
        public Cylindrical(String id) { super(id, 120); }
        public String getType() { return "Goods - Cylindrical"; }
    }

    // 🚀 Main Method
    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        // Add Bogies
        bogies.add(new Sleeper("S1"));
        bogies.add(new ACChair("AC1"));
        bogies.add(new FirstClass("F1"));
        bogies.add(new Rectangular("G1"));
        bogies.add(new Cylindrical("G2"));
        bogies.add(new Sleeper("S2"));
        bogies.add(new ACChair("AC2"));

        // 🔥 UC9: Grouping using Streams
        Map<String, List<Bogie>> groupedBogies =
                bogies.stream()
                        .collect(Collectors.groupingBy(Bogie::getType));

        // 📊 Display Grouped Data
        System.out.println("\n--- Grouped Bogies by Type ---");

        for (Map.Entry<String, List<Bogie>> entry : groupedBogies.entrySet()) {
            System.out.println("\nType: " + entry.getKey());

            for (Bogie b : entry.getValue()) {
                System.out.println("   " + b);
            }
        }
    }
}