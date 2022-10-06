package com.usa.reto3v2.controller;

import com.usa.reto3v2.entities.Admin;
import com.usa.reto3v2.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/Admin")
@CrossOrigin(origins = "*")
public class AdminController {

    @Autowired
    private AdminService adminService;

    @GetMapping("/all")
    public List<Admin> getAll(){
        return adminService.getAll();
    }


    @GetMapping("/{id}")
    public ResponseEntity<Admin> get(@PathVariable Integer id) {
        try {
            Admin admin = adminService.getAdmin(id).get();
            return new ResponseEntity<Admin>(admin, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
        }
    }
    @PostMapping("/save")
    public Admin save(@RequestBody Admin ad){
        return adminService.save(ad);
    }
    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Admin> getAllClient2(){
        return adminService.getAll();
    }


    @DeleteMapping("/delete/{idAdmin}")
    public boolean deleteAdmin(@PathVariable Integer idAdmin){
        return adminService.delete(idAdmin);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin updateAdmin(@RequestBody Admin admin){
        return adminService.Update(admin);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Admin> update(@PathVariable Integer id) {
        Admin admin = adminService.getAdmin(id).get();
        try {
             admin = adminService.getAdmin(id).get();
            return new ResponseEntity<Admin>(admin, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Admin>(HttpStatus.NOT_FOUND);
        }
    }

}
