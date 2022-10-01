package com.usa.reto3v2.controller;

import com.usa.reto3v2.entities.Message;
import com.usa.reto3v2.service.MessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/Message")
public class MessageController {

    @Autowired
    private MessageService messageService;

    @GetMapping("/all")
    public List<Message> getAll(){
        return messageService.getAll();
    }
    @PostMapping("/save")
    public Message save(@RequestBody Message ad){
        return messageService.save(ad);
    }

}
