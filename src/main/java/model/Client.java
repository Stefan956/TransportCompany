package model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "clients")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Client extends Person{

    @Id
    @Column(name = "client_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;


    boolean hasPaid;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "company_id")
    Company company;

    @OneToMany (fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    List<Trip> trips = new ArrayList<>();

    @Override
    public String toString() {
        return "Client{" +
                "id=" + id +
                ", firstName='" + this.getFirstName() + '\'' +
                ", lastName='" + this.getLastName() + '\'' +
                ", hasPaid=" + hasPaid +
                '}';
    }
}
