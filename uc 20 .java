class EmptyTrainException extends Exception {
    public EmptyTrainException(String message) {
        super(message);
    }
}
class Bogie {
    int id;
    String type;

    Bogie(int id, String type) {
        this.id = id;
        this.type = type;
    }
}
public class TrainConsistApp {

    public static int safeBinarySearch(Bogie[] bogies, int targetId)
            throws EmptyTrainException {

        // ✅ Fail-fast validation
        if (bogies == null || bogies.length == 0) {
            throw new EmptyTrainException("Train has no bogies. Search aborted.");
        }

        int low = 0;
        int high = bogies.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (bogies[mid].id == targetId) {
                return mid;
            } else if (bogies[mid].id < targetId) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return -1; // Not found
    }
