package hu.unimiskolc.java.halado.cardemo.persist;

import hu.unimiskolc.java.halado.cardemo.model.entity.Car;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface CarRepository extends CrudRepository<Car, Long> {
    List<Car> findAllByManufacturerId(long manufacturerId);
}
