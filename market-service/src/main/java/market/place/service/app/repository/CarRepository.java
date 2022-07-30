package market.place.service.app.repository;

import market.place.service.app.model.Car;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {

    List<Car> findAllByModel(String model, Pageable pageable);

    List<Car> findAllByPriceBetween(double start, double end, Pageable pageable);

    List<Car> findAllByOrderByPriceAsc(Pageable pageable);

    List<Car> findAllByOrderByPriceDesc(Pageable pageable);
}
