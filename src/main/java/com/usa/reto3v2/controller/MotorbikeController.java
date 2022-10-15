package com.usa.reto3v2.controller;

import com.usa.reto3v2.entities.Client;
import com.usa.reto3v2.entities.Motorbike;
import com.usa.reto3v2.service.MotorbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
    public Optional<Motorbike> getCategory (@PathVariable("id") int Id) {
        return motorbikeService.getMotorbike(Id);
    }
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorbike save(@RequestBody Motorbike p){
        return motorbikeService.save(p);
    }
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Motorbike update(@RequestBody Motorbike motorbike) {
        return motorbikeService.update(motorbike);
    }
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete (@PathVariable("id") int id){
        return motorbikeService.deleteMotorbike(id);
    }
}
