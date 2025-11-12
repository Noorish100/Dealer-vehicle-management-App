package com.app.vehicle_management.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.app.vehicle_management.entity.Vehicle;
import com.app.vehicle_management.repository.VehicleRepository;

@RestController
@RequestMapping("/vehicles")
public class VehicleController {

    @Autowired
    private VehicleRepository vehicleRepository;

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleRepository.save(vehicle);
    }

  @PutMapping("/{id}")
  public ResponseEntity<Vehicle> updateVehicle(@PathVariable Integer id, @RequestBody Vehicle updatedVehicle) {
    return vehicleRepository.findById(id).map(vehicle -> {
        vehicle.setModel(updatedVehicle.getModel());
        vehicle.setPrice(updatedVehicle.getPrice());
        vehicle.setStatus(updatedVehicle.getStatus());
        vehicle.setDealer(updatedVehicle.getDealer());
        return ResponseEntity.ok(vehicleRepository.save(vehicle));
    }).orElse(ResponseEntity.notFound().build());
}


    @DeleteMapping("/{id}")
    public void deleteVehicle(@PathVariable Integer id) {
        vehicleRepository.deleteById(id);
    }

    @GetMapping("/premium")
    public List<Vehicle> getVehiclesByPremiumDealers() {
        return vehicleRepository.findVehiclesByPremiumDealers();
    }
}
