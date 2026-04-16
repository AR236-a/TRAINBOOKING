import java.util.*;
import java.util.stream.*;

// 🚉 Main Class
public class TrainUC13 {

    // 🔷 Bogie Class
    static class Bogie {
        String id;
        int capacity;

        public Bogie(String id, int capacity) {
            this.id = id;
            this.capacity = capacity;
        }

        public int getCapacity() {
            return capacity;
        }

        @Override
        public String toString() {
            return "Bogie [ID=" + id + ", Cap=" + capacity + "]";
        }
    }

    // 🚀 Main Method
    public static void main(String[] args) {

        List<Bogie> bogies = new ArrayList<>();

        // 🔹 Create Large Dataset
        for (int i = 1; i <= 100000; i++) {
            int cap = (i % 3 == 0) ? 40 : (i % 2 == 0 ? 60 : 72);
            bogies.add(new Bogie("B" + i, cap));
        }

        // ===============================
        // 🔥 LOOP-BASED FILTERING
        // ===============================
        long startLoop = System.nanoTime();

        List<Bogie> loopResult = new ArrayList<>();
        for (Bogie b : bogies) {
            if (b.getCapacity() > 60) {
                loopResult.add(b);
            }
        }

        long endLoop = System.nanoTime();
        long loopTime = endLoop - startLoop;

        // ===============================
        // 🔥 STREAM-BASED FILTERING
        // ===============================
        long startStream = System.nanoTime();

        List<Bogie> streamResult = bogies.stream()
                .filter(b -> b.getCapacity() > 60)
                .collect(Collectors.toList());

        long endStream = System.nanoTime();
        long streamTime = endStream - startStream;

        // ===============================
        // 📊 OUTPUT
        // ===============================
        System.out.println("\n--- Performance Comparison ---");

        System.out.println("Loop Result Size: " + loopResult.size());
        System.out.println("Stream Result Size: " + streamResult.size());

        System.out.println("\nLoop Execution Time   : " + loopTime + " ns");
        System.out.println("Stream Execution Time : " + streamTime + " ns");

        // ✅ Consistency Check
        if (loopResult.size() == streamResult.size()) {
            System.out.println("\nResults Match ✅");
        } else {
            System.out.println("\nResults Do NOT Match ❌");
        }
    }
}