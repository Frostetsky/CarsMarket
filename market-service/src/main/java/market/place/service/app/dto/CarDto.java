package market.place.service.app.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class CarDto {

    private String model;

    private String description;

    private double price;
}
