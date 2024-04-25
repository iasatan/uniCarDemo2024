package hu.unimiskolc.java.halado.cardemo.controller;

import hu.unimiskolc.java.halado.cardemo.model.dto.ManufacturerDto;
import hu.unimiskolc.java.halado.cardemo.model.entity.Manufacturer;
import hu.unimiskolc.java.halado.cardemo.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatusCode;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManufacturerController {
    @Autowired
    private ManufacturerService manufacturerService;

    @GetMapping("/manufacturers")
    public List<ManufacturerDto> GetAllManufacturers() {
        return manufacturerService.listManufacturers();
    }

    @PostMapping("/addManufacturer")
    public void CreateManufacturer(@RequestBody Manufacturer manufacturer) {
        manufacturerService.createManufacturer(manufacturer);
    }
}
