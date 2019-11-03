/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.cinema.controllers;

import hu.elte.cinema.entities.Projection;
import hu.elte.cinema.repositories.ProjectionRepository;
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

/**
 *
 * @author dnhfms
 */
@RestController
@RequestMapping("/projections")
public class ProjectionController {

    @Autowired
    private ProjectionRepository projectionRepository;

    @GetMapping("")
    public ResponseEntity<Iterable<Projection>> getAll() {
        return ResponseEntity.ok(projectionRepository.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Projection> get(@PathVariable Integer id) {
        Optional<Projection> projection = projectionRepository.findById(id);
        if (projection.isPresent()) {
            return ResponseEntity.ok(projection.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping("")
    public ResponseEntity<Projection> post(@RequestBody Projection projection) {
        Projection savedProjection = projectionRepository.save(projection);
        return ResponseEntity.ok(savedProjection);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Projection> put(@RequestBody Projection projection, @PathVariable Integer id) {
        Optional<Projection> oProjection = projectionRepository.findById(id);
        if (oProjection.isPresent()) {
            projection.setId(id);
            return ResponseEntity.ok(projectionRepository.save(projection));
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    @DeleteMapping("/{id}")
    public ResponseEntity delete(@PathVariable Integer id) {
        Optional<Projection> oProjection = projectionRepository.findById(id);
        if (oProjection.isPresent()) {
            projectionRepository.deleteById(id);
            return ResponseEntity.ok().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

}
