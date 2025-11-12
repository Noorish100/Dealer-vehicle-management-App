package com.app.vehicle_management.controller;

import java.util.Timer;
import java.util.TimerTask;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.vehicle_management.entity.Payment;
import com.app.vehicle_management.repository.PaymentRepository;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/payment")
public class PaymentController {
    @Autowired
    private PaymentRepository paymentRepo;

    @PostMapping("/initiate")
    public Payment initiate(@RequestBody Payment payment) {
        payment.setStatus("PENDING");
        Payment saved = paymentRepo.save(payment);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                saved.setStatus("SUCCESS");
                paymentRepo.save(saved);
            }
        }, 5000);

        return saved;
    }
}