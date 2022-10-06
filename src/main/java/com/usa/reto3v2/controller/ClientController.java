package com.usa.reto3v2.controller;

import com.usa.reto3v2.entities.Client;
import com.usa.reto3v2.entities.Client;
import com.usa.reto3v2.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/api/Client")
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

    @PostMapping("/all")
    @ResponseStatus(HttpStatus.CREATED)
    public List<Client> getAllClient2(){
        return clientService.getAll();
    }


    @DeleteMapping("/delete/{idClient}")
    public boolean deleteClient(@PathVariable Integer idClient){
        return clientService.delete(idClient);
    }

    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Client updateClient(@RequestBody Client client){
        return clientService.update(client);
    }

    @PutMapping ("/{id}")
    public ResponseEntity<Client> update(@PathVariable Integer id) {
        Client client = clientService.getClient(id).get();
        try {
            client = clientService.getClient(id).get();
            return new ResponseEntity<Client>(client, HttpStatus.OK);
        } catch (NoSuchElementException e) {
            return new ResponseEntity<Client>(HttpStatus.NOT_FOUND);
        }
    }
}
