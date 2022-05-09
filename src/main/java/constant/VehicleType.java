package constant;

public enum VehicleType {
    BUS("BUS"), TRUCK("TRUCK"), CISTERN("CISTERN");

    private final String name;

    VehicleType(String name) {
        this.name = name;
    }
}
