package com.app.vehicle_management.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.app.vehicle_management.entity.Vehicle;

public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

     @Query("SELECT v FROM Vehicle v WHERE v.dealer.subscriptionType = 'PREMIUM'")
      List<Vehicle> findVehiclesByPremiumDealers();


}
