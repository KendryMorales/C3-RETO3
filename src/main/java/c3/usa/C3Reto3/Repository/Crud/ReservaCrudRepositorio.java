package c3.usa.C3Reto3.Repository.Crud;

import c3.usa.C3Reto3.Model.Reserva;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;
import java.util.Date;


/**
 *
 * @author KENDRY
 */
public interface ReservaCrudRepositorio extends CrudRepository<Reserva, Integer> {
    public List<Reserva> findAllByStatus(String status);
    public List<Reserva> findAllByStartDateAfterAndStartDateBefore(Date dateOne, Date dateTwo);
    
  @Query ("SELECT c.client, COUNT(c.client) from Reserva AS c group by c.client order by COUNT(c.client)DESC")
public List<Object[]> countTotalReservationsByClient();

}
