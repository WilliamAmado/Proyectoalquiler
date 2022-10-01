package com.usa.reto3v2.controller;

import com.usa.reto3v2.entities.Client;
import com.usa.reto3v2.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/client")
public class ClientController {

    @Autowired
    private ClientService clientService;

    @GetMapping("/all")
    public List<Client> getAll(){
        return clientService.getAll();
    }
    @PostMapping("/save")
    public Client save(@RequestBody Client c){
        return clientService.save(c);
    }
}
