/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.cinema.controllers;

import hu.elte.cinema.entities.Coupon;
import hu.elte.cinema.repositories.CouponRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dnhfms
 */
@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/coupons")
public class CouponController {

    @Autowired
    private CouponRepository couponRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<Coupon>> getAll() {
        return ResponseEntity.ok(couponRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coupon> get(@PathVariable Integer id) {
        Optional<Coupon> coupon = couponRepository.findById(id);
        if (coupon.isPresent()) {
            return ResponseEntity.ok(coupon.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Coupon> post(@RequestBody Coupon coupon) {
        Coupon savedCoupon = couponRepository.save(coupon);
        return ResponseEntity.ok(savedCoupon);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coupon> put(@RequestBody Coupon coupon, @PathVariable Integer id) {
        Optional<Coupon> oCoupon = couponRepository.findById(id);
        if (oCoupon.isPresent()) {
            coupon.setId(id);
            return ResponseEntity.ok(couponRepository.save(coupon));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Coupon> oCoupon = couponRepository.findById(id);
        if (oCoupon.isPresent()) {
            couponRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
