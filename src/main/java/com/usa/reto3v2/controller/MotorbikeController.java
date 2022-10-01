package com.usa.reto3v2.controller;

import com.usa.reto3v2.entities.Motorbike;
import com.usa.reto3v2.service.MotorbikeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motorbike")
public class MotorbikeController {

    @Autowired
    private MotorbikeService motorbikeService;

    @GetMapping("/all")
    public List<Motorbike> getAll(){
        return motorbikeService.getAll();
    }
    @PostMapping("/save")
    public Motorbike save(@RequestBody Motorbike mt){
        return motorbikeService.save(mt);
    }

}
