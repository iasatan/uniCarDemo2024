package hu.unimiskolc.java.halado.cardemo.service;

import hu.unimiskolc.java.halado.cardemo.model.dto.ManufacturerDto;
import hu.unimiskolc.java.halado.cardemo.model.entity.Manufacturer;

import java.util.List;

public interface ManufacturerService {
    void createManufacturer(Manufacturer manufacturer);
    void deleteManufacturer(Long manufacturerId);
    List<ManufacturerDto> listManufacturers();
    Manufacturer getManufacturer(Long manufacturerId);
}
