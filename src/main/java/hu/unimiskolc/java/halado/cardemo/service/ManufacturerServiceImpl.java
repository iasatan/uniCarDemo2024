package hu.unimiskolc.java.halado.cardemo.service;

import hu.unimiskolc.java.halado.cardemo.model.dto.CarDto;
import hu.unimiskolc.java.halado.cardemo.model.dto.ManufacturerDto;
import hu.unimiskolc.java.halado.cardemo.model.entity.Manufacturer;
import hu.unimiskolc.java.halado.cardemo.persist.ManufacturerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class ManufacturerServiceImpl implements ManufacturerService {
    private ManufacturerRepository manufacturerRepository;

    @Autowired
    public ManufacturerServiceImpl(ManufacturerRepository manufacturerRepository) {
        this.manufacturerRepository = manufacturerRepository;
        Manufacturer manufacturer = Manufacturer.builder().name("Toyota").founded(LocalDate.now()).build();
        createManufacturer(manufacturer);
    }

    @Override
    public void createManufacturer(Manufacturer manufacturer) {
        manufacturerRepository.save(manufacturer);

    }

    @Override
    public void deleteManufacturer(Long manufacturerId) {
        manufacturerRepository.deleteById(manufacturerId);

    }

    @Override
    public List<ManufacturerDto
            > listManufacturers() {
        List<Manufacturer> manufacturers = (List<Manufacturer>) manufacturerRepository.findAll();
        List<ManufacturerDto> manufacturerDtos = manufacturers.stream().map(manufacturer -> ManufacturerDto.builder()
                .id(manufacturer.getId())
                .name(manufacturer.getName())
                .cars(manufacturer.getCars().stream().map(car -> CarDto.builder().name(car.getName()).build()).toList())
                .build()).toList();
        return manufacturerDtos;
    }

    @Override
    public Manufacturer getManufacturer(Long manufacturerId) {
        return manufacturerRepository.findById(manufacturerId).get();
    }
}
