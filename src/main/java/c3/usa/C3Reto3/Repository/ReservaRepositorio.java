package c3.usa.C3Reto3.Repository;

import c3.usa.C3Reto3.Model.Reserva;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KENDRY
 */
    @Repository
public class ReservaRepositorio {
       @Autowired
    private ReservaCrudRepositorio crud4;

    public List<Reserva> getAll(){
        return (List<Reserva>) crud4.findAll();
    }
    public Optional<Reserva> getReservation(int id){
        return crud4.findById(id);
    }
    public Reserva save(Reserva Reserva){
        return crud4.save(Reserva);
    }
    public void delete(Reserva Reserva){
        crud4.delete(Reserva);
    }

}
