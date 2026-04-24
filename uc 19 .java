import java.util.Arrays;
import java.util.Comparator;

Arrays.sort(bogies, Comparator.comparingInt(b -> b.id));
public static int binarySearch(Bogie[] bogies, int targetId) {

    int low = 0;
    int high = bogies.length - 1;

    while (low <= high) {

        int mid = (low + high) / 2;

        if (bogies[mid].id == targetId) {
            return mid; // Found
        }
        else if (bogies[mid].id < targetId) {
            low = mid + 1;
        }
        else {
            high = mid - 1;
        }
    }

    return -1; // Not found
}
public class TrainConsistApp {

    public static void main(String[] args) {

        Bogie[] bogies = {
                new Bogie(309, "First Class"),
                new Bogie(101, "Sleeper"),
                new Bogie(205, "AC Chair"),
                new Bogie(150, "General")
        };

        // Sort first
        Arrays.sort(bogies, Comparator.comparingInt(b -> b.id));

        int searchId = 205;

        int result = binarySearch(bogies, searchId);

        if (result != -1) {
            System.out.println("Bogie Found:");
            System.out.println("ID: " + bogies[result].id +
                    ", Type: " + bogies[result].type);
        } else {
            System.out.println("Bogie not found.");
        }
    }
}