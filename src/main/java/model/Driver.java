package model;

import constant.DriverQualification;
import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "drivers")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Driver extends Person{

    @Id
    @Column(name = "driver_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    DriverQualification qualification;

    double salary;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    Company company;

    @OneToMany (fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    List<Trip> trips = new ArrayList<>();


    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", firstName='" + this.getFirstName() + '\'' +
                ", lastName='" + this.getLastName() + '\'' +
                ", qualification=" + qualification.toString() +
                ", salary=" + salary +
                '}';
    }
}