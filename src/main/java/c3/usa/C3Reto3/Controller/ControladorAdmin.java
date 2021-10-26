package c3.usa.C3Reto3.Controller;

import c3.usa.C3Reto3.Model.Admin;
import c3.usa.C3Reto3.Service.ServicioAdmin;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * 
 * @author KENDRY
 */
@RestController
@RequestMapping("/api/Admin")
@CrossOrigin("*")
public class ControladorAdmin {
    @Autowired
    private ServicioAdmin servicio;
    
    @GetMapping("/all")
    public List<Admin> getAll(){
        return servicio.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Admin> getAdmin(@PathVariable("id") int adminId) {
        return servicio.getAdmin(adminId);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin save(@RequestBody Admin admin){
        return servicio.save(admin);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin update(@RequestBody Admin admin) {
        return servicio.update(admin);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean delete(@PathVariable("id") int adminId) {
        return servicio.deleteAdmin(adminId);
    } 
}
