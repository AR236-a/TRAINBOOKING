class UnsafeCargoException extends Exception {
    public UnsafeCargoException(String msg) {
        super(msg);
    }
}

class Bogie {
    String type;

    Bogie(String type) {
        this.type = type;
    }

    void assignCargo(String cargo) throws UnsafeCargoException {
        if (type.equals("Rectangular") && cargo.equals("Petroleum")) {
            throw new UnsafeCargoException("Unsafe cargo assignment!");
        }
        System.out.println("Cargo assigned: " + cargo);
    }
}

public class Main {
    public static void main(String[] args) {

        Bogie b = new Bogie("Rectangular");

        try {
            b.assignCargo("Petroleum");  // Unsafe case
        } catch (UnsafeCargoException e) {
            System.out.println("Error: " + e.getMessage());
        } finally {
            System.out.println("Operation logged. System safe.");
        }

        System.out.println("App continues running...");
    }
}