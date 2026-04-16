import java.util.*;
import java.util.stream.*;

// 🚉 Main Class
public class TrainApp {

    // 🔷 Abstract Bogie Class
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

        @Override
        public String toString() {
            return getType() + " Bogie [ID=" + id + ", Capacity=" + capacity + "]";
        }
    }

    // 🚍 Passenger Bogies
    static class Sleeper extends Bogie {
        public Sleeper(String id) {
            super(id, 72);
        }

        public String getType() {
            return "Sleeper";
        }
    }

    static class ACChair extends Bogie {
        public ACChair(String id) {
            super(id, 60);
        }

        public String getType() {
            return "AC Chair";
        }
    }

    static class FirstClass extends Bogie {
        public FirstClass(String id) {
            super(id, 40);
        }

        public String getType() {
            return "First Class";
        }
    }

    // 🚆 Train Class
    static class Train {
        private List<Bogie> bogies = new ArrayList<>();

        public void addBogie(Bogie b) {
            bogies.add(b);
        }

        public void displayAll() {
            System.out.println("\n--- All Bogies ---");
            bogies.forEach(System.out::println);
        }

        // 🔥 UC8: Stream Filtering
        public void filterByCapacity(int minCapacity) {
            System.out.println("\n--- Filtered Bogies (Capacity >= " + minCapacity + ") ---");

            bogies.stream()
                    .filter(b -> b.getCapacity() >= minCapacity)
                    .forEach(System.out::println);
        }

        // 🔥 Extra: Count High Capacity
        public void countHighCapacity(int minCapacity) {
            long count = bogies.stream()
                    .filter(b -> b.getCapacity() >= minCapacity)
                    .count();

            System.out.println("\nTotal High Capacity Bogies: " + count);
        }
    }

    // 🚀 Main Method
    public static void main(String[] args) {

        Train train = new Train();

        // Adding bogies
        train.addBogie(new Sleeper("S1"));
        train.addBogie(new ACChair("AC1"));
        train.addBogie(new FirstClass("F1"));
        train.addBogie(new Sleeper("S2"));
        train.addBogie(new FirstClass("F2"));

        // Display all bogies
        train.displayAll();

        // 🔍 UC8 Filtering using Streams
        train.filterByCapacity(60);

        // 📊 Count filtered bogies
        train.countHighCapacity(60);
    }
}