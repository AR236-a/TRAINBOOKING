import java.util.Scanner;
import java.util.regex.*;

// 🚉 Main Class
public class TrainUC11 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // 🔹 Input from user
        System.out.print("Enter Train ID: ");
        String trainId = sc.nextLine();

        System.out.print("Enter Cargo Code: ");
        String cargoCode = sc.nextLine();

        // 🔥 Regex Patterns
        String trainPatternStr = "TRN-\\d{4}";
        String cargoPatternStr = "PET-[A-Z]{2}";

        // 🔧 Compile Patterns
        Pattern trainPattern = Pattern.compile(trainPatternStr);
        Pattern cargoPattern = Pattern.compile(cargoPatternStr);

        // 🔍 Create Matchers
        Matcher trainMatcher = trainPattern.matcher(trainId);
        Matcher cargoMatcher = cargoPattern.matcher(cargoCode);

        // ✅ Validation using matches()
        boolean isTrainValid = trainMatcher.matches();
        boolean isCargoValid = cargoMatcher.matches();

        // 📊 Output Results
        System.out.println("\n--- Validation Result ---");

        if (isTrainValid) {
            System.out.println("Train ID is VALID");
        } else {
            System.out.println("Train ID is INVALID");
        }

        if (isCargoValid) {
            System.out.println("Cargo Code is VALID");
        } else {
            System.out.println("Cargo Code is INVALID");
        }

        sc.close();
    }
}