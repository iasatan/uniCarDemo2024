package hu.unimiskolc.java.halado.cardemo.service;

import hu.unimiskolc.java.halado.cardemo.model.dto.CarDto;
import hu.unimiskolc.java.halado.cardemo.model.entity.Car;
import hu.unimiskolc.java.halado.cardemo.persist.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CarServiceImpl implements  CarService{
    @Autowired
    private CarRepository carRepository;
    @Autowired
    private ManufacturerService manufacturerService;

    @Override
    public void createCar(CarDto carDto){
        Car car = new Car();
        car.setName(carDto.getName());
        car.setColor(carDto.getColor());
        car.setManufacturer(manufacturerService.getManufacturer(carDto.getManufacturerId()));
        carRepository.save(car);

    }

    @Override
    public void deleteCar(long carId) {

    }

    @Override
    public List<CarDto> listCars(long manufacturerId) {
        List<Car> cars = (List<Car>) carRepository.findAllByManufacturerId(manufacturerId);
        List<CarDto> carDtos = new ArrayList<>();
        for (Car car: cars) {
            CarDto carDto = new CarDto();
            carDto.setName(car.getName());
            carDto.setColor(car.getColor());
            carDto.setManufacturerId(car.getManufacturer().getId());
            carDto.setId(car.getId());
            carDtos.add(carDto);
        }

        return carDtos;
    }
}
