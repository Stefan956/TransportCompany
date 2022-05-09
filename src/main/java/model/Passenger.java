package model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "passenger")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Passenger extends Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    int id;

    @ManyToMany (fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    List<Trip> trips = new ArrayList<>();

    @Override
    public String toString() {
        return "Passenger{" +
                "id=" + id +
                ", trips=" + trips + '\'' +
                ", firstName='" + this.getFirstName() + '\'' +
                ", lastName='" + this.getLastName() + '\'' +
                '}';
    }
}