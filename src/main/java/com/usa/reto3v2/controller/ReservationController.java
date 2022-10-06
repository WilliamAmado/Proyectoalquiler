package com.usa.reto3v2.controller;

import com.usa.reto3v2.entities.Reservation;
import com.usa.reto3v2.entities.Reservation;
import com.usa.reto3v2.service.ReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/Reservation")
@CrossOrigin(origins = "*")
public class ReservationController {

    @Autowired
    private ReservationService reservationService;

    @GetMapping("/all")
    public List<Reservation> getAll(){
        return reservationService.getAll();
    }
    @PostMapping("/save")
    public Reservation save(@RequestBody Reservation rs){
       return reservationService.save(rs);
    }
    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Reservation> getAllReservation2(){
        return reservationService.getAll();
    }


    @DeleteMapping("/delete/{idReservation}")
    public boolean deleteReservation(@PathVariable Integer idReservation){
        return reservationService.delete(idReservation);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Reservation updateReservation(@RequestBody Reservation reservation){
        return reservationService.update(reservation);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Reservation> update(@PathVariable Integer id) {
        Reservation reservation = reservationService.getReservation(id).get();
        try {
            reservation = reservationService.getReservation(id).get();
            return new ResponseEntity<Reservation>(reservation, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Reservation>(HttpStatus.NOT_FOUND);
        }
    }

}
