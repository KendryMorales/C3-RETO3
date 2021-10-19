package c3.usa.C3Reto3.Repository;

import c3.usa.C3Reto3.Model.Cabin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

/**
 *
 * @author KENDRY
 */

//Trae y lleva informacion
@Repository
public class CabinRepositorio {
//Para inicializar objeto desde el framework
    @Autowired
    private CabinCrudRepositorio crud;
    
    //Consulta todos los elementos de la base de datos
    public List<Cabin> getAll() {
        //fuerza la compatibilidad, casteo
        return (List<Cabin>) crud.findAll();
    }

    //Recibe el id de la cabaña
    //optional 
    public Optional<Cabin> getCabin(int id) {
        return crud.findById(id);
    }

    //para gurdar o actualizar
    public Cabin save(Cabin cabin) {
        return crud.save(cabin);
    }   
    
    public void delete(Cabin cabin){
       crud.delete(cabin);
    }

}
