package c3.usa.C3Reto3.Service;

import c3.usa.C3Reto3.Model.Reserva;
import c3.usa.C3Reto3.Repository.ReservaRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author KENDRY
 */
@Service
public class ServicioReserva {
     @Autowired
    private ReservaRepositorio metodosCrud;

    public List<Reserva> getAll(){
        return metodosCrud.getAll();
    }

    public Optional<Reserva> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }

    public Reserva save(Reserva reservation){
        if(reservation.getIdReservation()==null){
            return metodosCrud.save(reservation);
        }else{
            Optional<Reserva> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(e.isEmpty()){
                return metodosCrud.save(reservation);
            }else{
                return reservation;
            }
        }
    }

    public Reserva update(Reserva reservation){
        if(reservation.getIdReservation()!=null){
            Optional<Reserva> e= metodosCrud.getReservation(reservation.getIdReservation());
            if(!e.isEmpty()){

                if(reservation.getStartDate()!=null){
                    e.get().setStartDate(reservation.getStartDate());
                }
                if(reservation.getDevolutionDate()!=null){
                    e.get().setDevolutionDate(reservation.getDevolutionDate());
                }
                if(reservation.getStatus()!=null){
                    e.get().setStatus(reservation.getStatus());
                }
                if(reservation.getCabin()!=null){
                    e.get().setCabin(reservation.getCabin());
                }
                if(reservation.getClient()!=null){
                    e.get().setClient(reservation.getClient());
                }
                if(reservation.getScore()!=null){
                    e.get().setScore(reservation.getScore());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return reservation;
            }
        }else{
            return reservation;
        }
    }

    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
