package market.place.service.app.service;

import lombok.RequiredArgsConstructor;
import market.place.service.app.dto.CarDto;
import market.place.service.app.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class CarService {

    private final CarRepository carRepository;
    private final Pageable pageable;

    public List<CarDto> findAllCars() {
        return carRepository.findAll(pageable)
                .stream()
                .map(entity -> CarDto.builder()
                        .description(entity.getDescription())
                        .price(entity.getPrice())
                        .model(entity.getModel())
                        .build())
                .collect(Collectors.toList());
    }

}
