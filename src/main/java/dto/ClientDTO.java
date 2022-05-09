package dto;

public class ClientDTO {

    private int id;

    private String firstName;
    private String lastName;
    private boolean hasPaid;

    public ClientDTO() {

    }

    public ClientDTO(int id, String firstName, String lastName, boolean hasPaid) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hasPaid = hasPaid;
    }

    @Override
    public String toString() {
        return "ClientDTO{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", hasPaid=" + hasPaid +
                '}';
    }
}
