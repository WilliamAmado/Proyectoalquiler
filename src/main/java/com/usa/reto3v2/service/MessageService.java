package com.usa.reto3v2.service;

import com.usa.reto3v2.entities.Category;
import com.usa.reto3v2.entities.Message;
import com.usa.reto3v2.repository.CategoryRepository;
import com.usa.reto3v2.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MessageService {
    @Autowired
    private MessageRepository messageRepository;
    public List<Message> getAll(){
        return messageRepository.getAll();
    }
    public Optional<Message> getMessage(int id){
        return messageRepository.getMessage(id);
    }
    public Message save(Message p){
        if(p.getIdMessage()==null){
            return messageRepository.save(p);
        }else{
            Optional<Message> e = messageRepository.getMessage(p.getIdMessage());
            if(e.isPresent()){
                return p;
            }else{
                return messageRepository.save(p);
            }
        }
    }
    public Message update(Message message){
        if(message.getIdMessage()!=null){
            Optional<Message> e= messageRepository.getMessage(message.getIdMessage());
            if(e.isPresent()){
                if(message.getMessageText()!=null){
                    e.get().setMessageText(message.getMessageText());
                }
                messageRepository.save(e.get());
                return e.get();
            }else{
                return message;
            }
        }else{
            return message;
        }
    }
    public boolean deleteMessage(int id){
        boolean d = getMessage(id).map(message -> {
            messageRepository.delete(message);
            return true;
        }).orElse(false);
        return d;
    }
}
