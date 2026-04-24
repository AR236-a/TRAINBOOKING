class Bogie {
    int id;
    String type;

    Bogie(int id, String type) {
        this.id = id;
        this.type = type;
    }
}
public class TrainConsistApp {

    public static int linearSearch(Bogie[] bogies, int targetId) {
        for (int i = 0; i < bogies.length; i++) {
            if (bogies[i].id == targetId) {
                return i; // Found
            }
        }
        return -1; // Not found
    }

    public static void main(String[] args) {

        Bogie[] bogies = {
                new Bogie(101, "Sleeper"),
                new Bogie(205, "AC Chair"),
                new Bogie(309, "First Class"),
                new Bogie(150, "General")
        };

        int searchId = 309;

        int result = linearSearch(bogies, searchId);

        if (result != -1) {
            System.out.println("Bogie Found:");
            System.out.println("ID: " + bogies[result].id +
                    ", Type: " + bogies[result].type);
        } else {
            System.out.println("Bogie not found.");
        }
    }
}