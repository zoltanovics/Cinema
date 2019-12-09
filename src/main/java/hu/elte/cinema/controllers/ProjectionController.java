/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.elte.cinema.controllers;

import hu.elte.cinema.dto.ProjectionDTO;
import hu.elte.cinema.entities.Movie;
import hu.elte.cinema.entities.Projection;
import hu.elte.cinema.entities.Room;
import hu.elte.cinema.repositories.MovieRepository;
import hu.elte.cinema.repositories.ProjectionRepository;
import hu.elte.cinema.repositories.RoomRepository;
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
@RequestMapping("/projections")
public class ProjectionController {

    @Autowired
    private ProjectionRepository projectionRepository;
    
    @Autowired
    private RoomRepository roomRepository;
    
    @Autowired
    private MovieRepository movieRepository;

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
    public ResponseEntity<Projection> put(@RequestBody ProjectionDTO projectionDTO, @PathVariable Integer id) {
        Optional<Projection> oProjection = projectionRepository.findById(projectionDTO.getId());
        Optional<Room> oRoom = roomRepository.findById(projectionDTO.getRoom()); 
        Optional<Movie> oMovie = movieRepository.findById(projectionDTO.getMovie());
        if (oProjection.isPresent()) { 
            Projection projection = new Projection();
            projection.setRoom(oRoom.get());
            projection.setMovie(oMovie.get());
            projection.setProjectionDate(projectionDTO.getProjectionDate());
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
