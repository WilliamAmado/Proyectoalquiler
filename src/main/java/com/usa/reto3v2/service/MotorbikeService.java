package com.usa.reto3v2.service;

import com.usa.reto3v2.entities.Motorbike;
import com.usa.reto3v2.repository.MotorbikeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MotorbikeService {

    @Autowired
    private MotorbikeRepository motorbikeRepository;

    public List<Motorbike> getAll(){
        return motorbikeRepository.getAll();
    }
    public Optional<Motorbike> getMotorbike(int id){
        return motorbikeRepository.getMotorbike(id);
    }
    public Motorbike save(Motorbike moto){
        if(moto.getId()==null){
            return motorbikeRepository.save(moto);
        }
        else{
            Optional<Motorbike> m=motorbikeRepository.getMotorbike(moto.getId());
            if(m.isPresent()){
                return m.get();
            }
            else{
                return motorbikeRepository.save(moto);
            }
        }
    }
    public Motorbike update(Motorbike moto){
        if(moto.getId()!=null){
           Optional<Motorbike> mt =motorbikeRepository.getMotorbike(moto.getId());
           if(mt.isPresent()){
               if(moto.getName()!=null){
                   mt.get().setName(moto.getName());
               }
               if(moto.getBrand()!=null){
                   mt.get().setBrand(moto.getBrand());
               }
               if(moto.getYear()!=null){
                   mt.get().setYear(moto.getYear());
               }
               if(moto.getDescription()!=null){
                   mt.get().setDescription(moto.getDescription());
               }
               motorbikeRepository.save(mt.get());
               return mt.get();
           }
           else{
               return moto;
           }
        }
        return moto;

    }
    public boolean delete(int id){
        boolean marca=false;
        Optional<Motorbike> mt =motorbikeRepository.getMotorbike(id);
        if(mt.isPresent()){
            motorbikeRepository.delete(mt.get());
            marca=true;
        }
        return marca;
    }
}
