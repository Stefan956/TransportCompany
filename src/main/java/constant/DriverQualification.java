package constant;

public enum DriverQualification {
    CATEGORY1("DANGEROUS_LOADS"), CATEGORY2("MORE_THAN_12_PEOPLE");

    private final String name;

    DriverQualification(String name) {
        this.name = name;
    }
}
