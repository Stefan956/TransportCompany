package model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "cargo")

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Cargo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    int id;

    String name;

    @ManyToOne (fetch = FetchType.LAZY)
    @JoinColumn(name = "trip_id")
    Trip trip;

    @Override
    public String toString() {
        return "Cargo{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}