package dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CargoDTO {

    private int id;

    private String name;

    @Override
    public String toString() {
        return "CargoDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
