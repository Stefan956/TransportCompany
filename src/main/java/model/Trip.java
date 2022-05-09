package model;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "trips")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Trip {

    @Id
    @Column(name = "trip_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String originPoint;
    String destinationPoint;

    LocalDate departureDate;
    LocalDate arrivalDate;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    Company company;

    @ManyToMany(mappedBy = "trips", cascade = CascadeType.ALL)
    List<Passenger> passengers = new java.util.ArrayList<>();

    @OneToMany(mappedBy = "trip", cascade = CascadeType.ALL)
    List<Cargo> load = new java.util.ArrayList<>();

    @ManyToOne
    Client client;

    @ManyToOne
    Driver driver;

    @ManyToOne
    Vehicle vehicle;

    double weight;

    double cost;

    public Trip(int id, String originPoint, String destinationPoint, LocalDate departureDate,
                LocalDate arrivalDate, List<Passenger> passengers, double cost) {
        this.id = id;
        this.originPoint = originPoint;
        this.destinationPoint = destinationPoint;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.passengers = passengers;
        this.cost = cost;
    }

    public Trip(int id, String originPoint, String destinationPoint, LocalDate departureDate,
                LocalDate arrivalDate, List<Cargo> load, double weight, double cost) {
        this.id = id;
        this.originPoint = originPoint;
        this.destinationPoint = destinationPoint;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.load = load;
        this.weight = weight;
        this.cost = cost;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", originPoint='" + originPoint + '\'' +
                ", destinationPoint='" + destinationPoint + '\'' +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", weight=" + weight +
                ", price=" + cost +
                '}';
    }
}
