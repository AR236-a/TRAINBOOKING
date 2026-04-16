import java.util.*;
import java.util.stream.*;

// 🚉 Main Class
public class TrainUC12 {

    // 🔷 Goods Bogie Class
    static class GoodsBogie {
        String id;
        String type;   // Cylindrical / Rectangular / Open / Box
        String cargo;  // Petroleum / Coal / Grain etc.

        public GoodsBogie(String id, String type, String cargo) {
            this.id = id;
            this.type = type;
            this.cargo = cargo;
        }

        @Override
        public String toString() {
            return type + " Bogie [ID=" + id + ", Cargo=" + cargo + "]";
        }
    }

    // 🚀 Main Method
    public static void main(String[] args) {

        List<GoodsBogie> bogies = new ArrayList<>();

        // ✅ Sample Data
        bogies.add(new GoodsBogie("G1", "Cylindrical", "Petroleum"));
        bogies.add(new GoodsBogie("G2", "Rectangular", "Coal"));
        bogies.add(new GoodsBogie("G3", "Open", "Grain"));

        // ❌ Uncomment to test failure case
        // bogies.add(new GoodsBogie("G4", "Cylindrical", "Coal"));

        // 🔥 UC12: Safety Validation using allMatch()
        boolean isSafe = bogies.stream()
                .allMatch(b ->
                        // Rule:
                        // If Cylindrical → must be Petroleum
                        !b.type.equals("Cylindrical") || b.cargo.equals("Petroleum")
                );

        // 📊 Output
        System.out.println("\n--- Goods Bogies ---");
        bogies.forEach(System.out::println);

        System.out.println("\n--- Safety Compliance Result ---");

        if (isSafe) {
            System.out.println("Train is SAFE ✅");
        } else {
            System.out.println("Train is UNSAFE ❌");
        }
    }
}