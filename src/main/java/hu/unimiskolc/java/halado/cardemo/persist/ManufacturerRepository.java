package hu.unimiskolc.java.halado.cardemo.persist;

import hu.unimiskolc.java.halado.cardemo.model.entity.Manufacturer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

@Component
public interface ManufacturerRepository extends CrudRepository<Manufacturer, Long> {
}
