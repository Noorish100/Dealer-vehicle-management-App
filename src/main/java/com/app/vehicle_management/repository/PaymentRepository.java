package com.app.vehicle_management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.app.vehicle_management.entity.Payment;

public interface PaymentRepository extends JpaRepository<Payment, Long> {}
