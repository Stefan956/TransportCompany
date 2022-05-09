package dto;

import java.time.LocalDate;

public class TripDTO {

    private int id;
    private String originPoint;
    private String destinationPoint;

    private LocalDate departureDate;
    private LocalDate arrivalDate;

    private double weight;

    private double price;

    public TripDTO() {

    }

    public TripDTO(int id, String originPoint, String destinationPoint, LocalDate departureDate, LocalDate arrivalDate, double price) {
        this.id = id;
        this.originPoint = originPoint;
        this.destinationPoint = destinationPoint;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.price = price;
    }

    public TripDTO(int id, String originPoint, String destinationPoint, LocalDate departureDate, LocalDate arrivalDate, double weight, double price) {
        this.id = id;
        this.originPoint = originPoint;
        this.destinationPoint = destinationPoint;
        this.departureDate = departureDate;
        this.arrivalDate = arrivalDate;
        this.weight = weight;
        this.price = price;
    }

    @Override
    public String toString() {
        return "TripDTO{" +
                "id=" + id +
                ", originPoint='" + originPoint + '\'' +
                ", destinationPoint='" + destinationPoint + '\'' +
                ", departureDate=" + departureDate +
                ", arrivalDate=" + arrivalDate +
                ", weight=" + weight +
                ", price=" + price +
                '}';
    }
}
