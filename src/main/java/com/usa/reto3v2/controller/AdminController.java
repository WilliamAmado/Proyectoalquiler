package com.usa.reto3v2.controller;

import com.usa.reto3v2.entities.Admin;
import com.usa.reto3v2.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Admin")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<Admin> getAll(){
        return adminService.getAll();
    }
    @PostMapping("/save")
    public Admin save(@RequestBody Admin ad){
       return adminService.save(ad);
    }

}
