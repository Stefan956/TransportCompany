package dto;

import constant.DriverQualification;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class DriverDTO {
    private int id;

    private String firstName;
    private String lastName;
    private DriverQualification driverQualification;
    private double salary;

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
