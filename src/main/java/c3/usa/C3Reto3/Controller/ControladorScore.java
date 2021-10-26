package c3.usa.C3Reto3.Controller;

import c3.usa.C3Reto3.Model.Score;
import c3.usa.C3Reto3.Service.ServicioScore;
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
@RequestMapping("/api/Score")
@CrossOrigin("*")
public class ControladorScore {
    @Autowired
    private ServicioScore servicio;
    
    @GetMapping("/all")
    public List<Score> getAll(){
        return servicio.getAll();
    }
    
    @GetMapping("/{id}")
    public Optional<Score> getScore(@PathVariable("id") int scoreId) {
        return servicio.getScore(scoreId);
    }
    
    @PostMapping("/save")
    @ResponseStatus(HttpStatus.CREATED)
    public Score save(@RequestBody Score score){
        return servicio.save(score);
    }
    
    @PutMapping("/update")
    @ResponseStatus(HttpStatus.CREATED)
    public Score update(@RequestBody Score score) {
        return servicio.update(score);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public boolean deleteScore(@PathVariable("id") int scoreId) {
        return servicio.deleteScore(scoreId);
    } 
}