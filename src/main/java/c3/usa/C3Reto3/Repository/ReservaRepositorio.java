package c3.usa.C3Reto3.Repository;

import c3.usa.C3Reto3.Model.Cliente;
import c3.usa.C3Reto3.Repository.Crud.ReservaCrudRepositorio;
import c3.usa.C3Reto3.Model.Reserva;
import c3.usa.C3Reto3.Reportes.ContadorClientes;
import java.util.Date;
import java.util.List;
import java.util.ArrayList;
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

    public List<Reserva> getAll() {
        return (List<Reserva>) crud4.findAll();
    }

    public Optional<Reserva> getReservation(int id) {
        return crud4.findById(id);
    }

    public Reserva save(Reserva Reserva) {
        return crud4.save(Reserva);
    }

    public void delete(Reserva Reserva) {
        crud4.delete(Reserva);
    }

    public List<Reserva> ReservacionStatus(String status) {
        return crud4.findAllByStatus(status);
    }

    public List<Reserva> ReservationTime(Date a, Date b) {
        return crud4.findAllByStartDateAfterAndStartDateBefore(a, b);
    }

    public List<ContadorClientes> getTopClientes() {
        List<ContadorClientes> res = new ArrayList<>();
        List<Object[]> report = crud4.countTotalReservationsByClient();
        
        for (int i = 0; i < report.size(); i++) {
            res.add(new ContadorClientes(
                    (Long) report.get(i)[1], 
                    (Cliente) report.get(i)[0]
            ));
        }
        
        return res;
    }
}


