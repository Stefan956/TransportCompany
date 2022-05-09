package dto;

public class PassengerDTO {

    private int id;

    private String name;

    public PassengerDTO() {

    }

    public PassengerDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "PassengerDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
