package com.app.vehicle_management.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.vehicle_management.entity.Dealer;
import com.app.vehicle_management.repository.DealerRepository;

@RestController
@RequestMapping("/dealers")
public class DealerController {

    @Autowired
    private DealerRepository dealerRepository;

    @GetMapping
    public List<Dealer> getAllDealers() {
        return dealerRepository.findAll();
    }

    @PostMapping
    public Dealer createDealer(@RequestBody Dealer dealer) {
        return dealerRepository.save(dealer);
    }

    @PutMapping("/{id}")
    public Dealer updateDealer(@PathVariable Integer id, @RequestBody Dealer dealer) {
        dealer.setId(id);
        return dealerRepository.save(dealer);
    }

    @DeleteMapping("/{id}")
    public void deleteDealer(@PathVariable Integer id) {
        dealerRepository.deleteById(id);
    }
}
