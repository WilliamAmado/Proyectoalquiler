package com.usa.reto3v2.controller;

import com.usa.reto3v2.entities.Motorbike;
import com.usa.reto3v2.service.MotorbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/Motorbike")
public class MotorbikeController {

    @Autowired
    private MotorbikeService motorbikeService;

    @GetMapping("/all")
    public List<Motorbike> getAll(){
        return motorbikeService.getAll();
    }
    @GetMapping("/{id}")
    public ResponseEntity<Motorbike> get(@PathVariable Integer id){
        try{
            Motorbike motorbike= motorbikeService.get(id);
            return new ResponseEntity<Motorbike>(motorbike, HttpStatus.OK);
        }catch (NoSuchElementException e){
            return new ResponseEntity<Motorbike>( HttpStatus.NOT_FOUND);
        }

    }
    @PostMapping("/save")
    public Motorbike  save(@RequestBody Motorbike mt){
        return   motorbikeService.save(mt);
    }

}
