package dto;

import java.math.BigDecimal;
import java.time.LocalDate;

public class CompanyDTO {

    private int id;

    private String name;

    public CompanyDTO() {
    }

    public CompanyDTO(int id, String name) {
        this.id = id;
        this.name = name;
    }

    @Override
    public String toString() {
        return "CompanyDTO{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
