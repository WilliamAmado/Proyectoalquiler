package com.usa.reto3v2.service;

import com.usa.reto3v2.entities.DTOs.CountClient;
import com.usa.reto3v2.entities.DTOs.CountStatus;
import com.usa.reto3v2.entities.Reservation;
import com.usa.reto3v2.repository.ReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import javax.transaction.Transactional;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ReservationService {

    @Autowired
    private ReservationRepository reservationRepository;

    public List<Reservation> getAll() {
        return reservationRepository.getAll();
    }

    public Optional<Reservation> getReservation(int id) {
        return reservationRepository.getReservation(id);
    }

    public Reservation save(Reservation r) {
        if (r.getIdReservation() == null) {
            return reservationRepository.save(r);
        } else {
            Optional<Reservation> a = reservationRepository.getReservation(r.getIdReservation());
            if (a.isPresent()) {
                return r;
            } else {
                return reservationRepository.save(r);
            }
        }
    }

    public Reservation update(Reservation r) {
        if (r.getIdReservation() != null) {
            Optional<Reservation> rs = reservationRepository.getReservation(r.getIdReservation());
            if (rs.isPresent()) {
                if (r.getStartDate() != null) {
                    rs.get().setStartDate(r.getStartDate());
                }
                if (r.getDevolutionDate() != null) {
                    rs.get().setDevolutionDate(r.getDevolutionDate());
                }
                if (r.getStatus() != null) {
                    rs.get().setStatus(r.getStatus());
                }
                if (r.getScore() != null) {
                    rs.get().setScore(r.getScore());
                }
                if (r.getMotorbike() != null) {
                    rs.get().setMotorbike(r.getMotorbike());
                }
                if (r.getClient() != null) {
                    rs.get().setClient(r.getClient());
                }


                reservationRepository.save(rs.get());
                return rs.get();

            } else {
                return r;
            }
        } else {
            return r;
        }
    }

    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(int id){
        boolean flag=false;
        Optional<Reservation>p= reservationRepository.getReservation(id);
        if(p.isPresent()){
            reservationRepository.delete(p.get());
            flag=true;
        }
        return flag;
    }

    public List<CountClient> getClientCasher(){
        return reservationRepository.getClientCasher();
    }
    public List<Reservation> getReservationsBetweenDates(String dateA, String dateB){
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date a = new Date();
        Date b = new Date();
        try{
            a = parser.parse(dateA);
            b = parser.parse(dateB);
        }catch (ParseException error){
            error.printStackTrace();
        }
        if(a.before(b)){
            return reservationRepository.getReservationsBetweenDates(a, b);
        }else{
            return new ArrayList<>();
        }
    }

    public CountStatus getReservationsStatus(){
        List<Reservation> reservascompletadas = reservationRepository.getReservationsByStatus("completed");
        List<Reservation> reservascanceladas = reservationRepository.getReservationsByStatus("cancelled");
        return new CountStatus((long) reservascompletadas.size(), (long) reservascanceladas.size());
    }
}

