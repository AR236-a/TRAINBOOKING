class PassengerBogie {
    String type;
    int capacity;

    PassengerBogie(String type, int capacity) {
        this.type = type;
        this.capacity = capacity;
    }
}
public class TrainConsistApp {

    public static void bubbleSort(PassengerBogie[] bogies) {
        int n = bogies.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {

                if (bogies[j].capacity > bogies[j + 1].capacity) {

                    // Swap bogies
                    PassengerBogie temp = bogies[j];
                    bogies[j] = bogies[j + 1];
                    bogies[j + 1] = temp;
                }
            }
        }
    }

    public static void main(String[] args) {

        PassengerBogie[] bogies = {
                new PassengerBogie("Sleeper", 72),
                new PassengerBogie("AC Chair", 50),
                new PassengerBogie("First Class", 30),
                new PassengerBogie("Sleeper", 80)
        };

        System.out.println("Before Sorting:");
        for (PassengerBogie b : bogies) {
            System.out.println(b.type + " - " + b.capacity);
        }

        bubbleSort(bogies);

        System.out.println("\nAfter Sorting (Ascending Capacity):");
        for (PassengerBogie b : bogies) {
            System.out.println(b.type + " - " + b.capacity);
        }
    }
}