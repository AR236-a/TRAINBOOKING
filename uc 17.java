import java.util.Arrays;

public class TrainConsistApp {

    public static void main(String[] args) {

        String[] bogieNames = {
                "Sleeper",
                "AC Chair",
                "First Class",
                "General",
                "Luxury"
        };

        System.out.println("Before Sorting:");
        for (String name : bogieNames) {
            System.out.println(name);
        }

        // Built-in sorting
        Arrays.sort(bogieNames);

        System.out.println("\nAfter Sorting (Alphabetical):");
        for (String name : bogieNames) {
            System.out.println(name);
        }
    }
}