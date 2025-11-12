package com.app.vehicle_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.vehicle_management.entity.Dealer;

public interface DealerRepository extends JpaRepository<Dealer, Integer> {

}
