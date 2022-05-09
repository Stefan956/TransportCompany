package model;

import constant.DriverQualification;
import constant.VehicleType;
import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "vehicles")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Vehicle {

    @Id
    @Column(name = "vehicle_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    String plate;

    VehicleType vehicleType;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    Company company;

    @Override
    public String toString() {
        return "Vehicle{" +
                "id=" + id +
                ", plate='" + plate + '\'' +
                ", vehicleType=" + vehicleType.toString() +
                '}';
    }
}
