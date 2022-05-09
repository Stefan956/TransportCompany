package dto;

import constant.DriverQualification;

public class DriverDTO {

    private int id;

    private String firstName;
    private String lastName;
    private DriverQualification driverQualification;
    private double salary;

    public DriverDTO() {

    }

    public DriverDTO(int id, String firstName, String lastName, DriverQualification driverQualification, double salary) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.driverQualification = driverQualification;
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "DriverDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", driverQualification=" + driverQualification +
                ", salary=" + salary +
                '}';
    }
}
