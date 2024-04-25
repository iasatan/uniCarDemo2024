package hu.unimiskolc.java.halado.cardemo.service;

import hu.unimiskolc.java.halado.cardemo.model.dto.CarDto;
import hu.unimiskolc.java.halado.cardemo.model.entity.Car;

import java.util.List;

public interface CarService {
    void createCar(CarDto carDto);
    void deleteCar(long carId);
    List<CarDto> listCars(long manufacturerId);
}
