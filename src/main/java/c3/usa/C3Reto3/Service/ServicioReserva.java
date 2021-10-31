package c3.usa.C3Reto3.Service;

import c3.usa.C3Reto3.Model.Reserva;
import c3.usa.C3Reto3.Reportes.ContadorClientes;
import c3.usa.C3Reto3.Reportes.StatusReservas;
import c3.usa.C3Reto3.Repository.ReservaRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.text.ParseException;
import java.util.ArrayList;

/**
 *
 * @author KENDRY
 */
@Service
public class ServicioReserva {

    /**
     *
     */
    @Autowired
    private ReservaRepositorio metodosCrud;

    /**
     *
     * @return
     */
    public List<Reserva> getAll() {
        return metodosCrud.getAll();
    }

    /**
     *
     * @param reservationId
     * @return
     */
    public Optional<Reserva> getReservation(int reservationId) {
        return metodosCrud.getReservation(reservationId);
    }

    /**
     *
     * @param reservation
     * @return
     */
    public Reserva save(Reserva reservation) {
        if (reservation.getIdReservation() == null) {
            return metodosCrud.save(reservation);
        } else {
            Optional<Reserva> prueba = metodosCrud.getReservation(
                    reservation.getIdReservation());
            if (prueba.isEmpty()) {
                return metodosCrud.save(reservation);
            } else {
                return reservation;
            }
        }
    }

    /**
     *
     * @param reservation
     * @return
     */
    public Reserva update(Reserva reservation) {
        if (reservation.getIdReservation() != null) {
            Optional<Reserva> prueba = metodosCrud.getReservation(
                    reservation.getIdReservation());
            
            if (!prueba.isEmpty()) {

                if (reservation.getStartDate() != null) {
                    prueba.get().setStartDate(reservation.getStartDate());
                }
                if (reservation.getDevolutionDate() != null) {
                    prueba.get().setDevolutionDate(
                            reservation.getDevolutionDate());
                }
                if (reservation.getStatus() != null) {
                    prueba.get().setStatus(reservation.getStatus());
                }
                if (reservation.getCabin() != null) {
                    prueba.get().setCabin(reservation.getCabin());
                }
                if (reservation.getClient() != null) {
                    prueba.get().setClient(reservation.getClient());
                }
                if (reservation.getScore() != null) {
                    prueba.get().setScore(reservation.getScore());
                }
                metodosCrud.save(prueba.get());
                return prueba.get();
            } else {
                return reservation;
            }
        } else {
            return reservation;
        }
    }

    /**
     *
     * @param reservationId
     * @return
     */
    public boolean deleteReservation(int reservationId) {
        Boolean aBoolean = getReservation(reservationId).map(reservation -> {
            metodosCrud.delete(reservation);
            return true;
        }).orElse(false);
        return aBoolean;
    }

    public StatusReservas getReporteStatusReservaciones() {
        List<Reserva> completed = metodosCrud.ReservacionStatus("completed");
        List<Reserva> cancelled = metodosCrud.ReservacionStatus("cancelled");
        return new StatusReservas(completed.size(), cancelled.size());
    }

    public List<Reserva> getReportesTiempoReservaciones(String datoA, 
            String datoB) {
        SimpleDateFormat parser = new SimpleDateFormat("yyyy-MM-dd");
        Date datoUno = new Date();
        Date datoDos = new Date();

        try {
            datoUno = parser.parse(datoA);
            datoDos = parser.parse(datoB);
        } catch (ParseException evt) {
            evt.printStackTrace();
        }
        
        if (datoUno.before(datoDos)) {
            return metodosCrud.ReservationTime(datoUno, datoDos);
        } else {
            return new ArrayList<>();
        }
    }

    public List<ContadorClientes> servicioTopClientes() {
        return metodosCrud.getTopClientes();
    }

}
