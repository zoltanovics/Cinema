/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.cinema.controllers;

import hu.elte.cinema.entities.Coupon;
import hu.elte.cinema.entities.User;
import hu.elte.cinema.repositories.CouponRepository;
import hu.elte.cinema.repositories.UserRepository;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@RequestMapping("/users")
public class UsersController {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    private CouponRepository couponRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<User>> getAll() {
        return ResponseEntity.ok(userRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> get(@PathVariable Integer id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return ResponseEntity.ok(user.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("/{id}/addCoupon/{couponName}")
    public ResponseEntity<User> post(@PathVariable Integer id, @PathVariable String couponName) {
        Optional<Coupon> oCoupon = couponRepository.findByName(couponName);
        Optional<User> oUser = userRepository.findById(id);
        if (oCoupon.isPresent()) {
            Coupon coupon = oCoupon.get();
            coupon.setId(oCoupon.get().getId());
            User user = oUser.get();
            user.getCoupons().add(coupon);
            user.setId(oUser.get().getId());
            ResponseEntity.ok(couponRepository.save(coupon));
            return ResponseEntity.ok(userRepository.save(user));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @PostMapping("")
    public ResponseEntity<User> post(@RequestBody User user) {
        User savedUser = userRepository.save(user);
        return ResponseEntity.ok(savedUser);
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> put(@RequestBody User user, @PathVariable Integer id) {
        Optional<User> oUser = userRepository.findById(id);
        if (oUser.isPresent()) {
            user.setId(id);
            return ResponseEntity.ok(userRepository.save(user));
        } else {
            return ResponseEntity.notFound().build();
        }
    } 
    
}
