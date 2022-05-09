package model;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "companies")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Company {

    @Id
    @Column(name = "company_id", updatable = false, nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;

    @Column(name="name", nullable = false)
    String name;

    @Column(name="initial_capital", nullable = false)
    double initial_capital;

    @Column(name="income", nullable = false)
    double income;

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    List<Vehicle> vehicles = new ArrayList<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    List<Driver> drivers = new ArrayList<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    List<Client> clients = new ArrayList<>();

    @OneToMany(mappedBy = "company", cascade = CascadeType.ALL)
    List<Trip> trips = new ArrayList<>();

    public Company(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Company{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
