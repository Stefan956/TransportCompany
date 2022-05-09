package dto;

import constant.VehicleType;

public class VehicleDTO {

    private int id;

    private String plate;
    private VehicleType vehicleType;

    public VehicleDTO() {

    }

    public VehicleDTO(int id, String plate, VehicleType vehicleType) {
        this.id = id;
        this.plate = plate;
        this.vehicleType = vehicleType;
    }

    @Override
    public String toString() {
        return "VehicleDTO{" +
                "id=" + id +
                ", plate='" + plate + '\'' +
                ", vehicleType=" + vehicleType +
                '}';
    }
}
