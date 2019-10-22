/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.cinema.repositories;

import hu.elte.cinema.entities.Coupon;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Bíró Zoltán
 */
@Repository
public interface CouponRepository extends CrudRepository<Coupon, Integer> {
    Coupon findByName(String name);
}
