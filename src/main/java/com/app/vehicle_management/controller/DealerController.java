package com.app.vehicle_management.controller;

import java.util.List;
import java.util.Optional;

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
        public ResponseEntity<Dealer> updateDealer(@PathVariable Integer id, @RequestBody Dealer updatedDealer) {
            return dealerRepository.findById(id).map(dealer -> {
                dealer.setName(updatedDealer.getName());
                dealer.setEmail(updatedDealer.getEmail());
                dealer.setSubscriptionType(updatedDealer.getSubscriptionType());
                return ResponseEntity.ok(dealerRepository.save(dealer));
            }).orElse(ResponseEntity.notFound().build());
        }

    @DeleteMapping("/{id}")
    public void deleteDealer(@PathVariable Integer id) {
        dealerRepository.deleteById(id);
    }
}
