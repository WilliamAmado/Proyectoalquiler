package com.usa.reto3v2.entities;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="messsage")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idMessage;
    private String messageText;


    public Message() {
    }

    public Message(Integer idMessage, String messageText) {
        this.idMessage = idMessage;
        this.messageText = messageText;
    }

    public Integer getIdMessage() {
        return idMessage;
    }

    public void setIdMessage(Integer idMessage) {
        this.idMessage = idMessage;
    }

    public String getMessageText() {
        return messageText;
    }

    public void setMessageText(String messageText) {
        this.messageText = messageText;
    }
}
