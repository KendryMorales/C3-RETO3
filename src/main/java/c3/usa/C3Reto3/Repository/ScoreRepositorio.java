package c3.usa.C3Reto3.Repository;

import c3.usa.C3Reto3.Model.Score;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import c3.usa.C3Reto3.Repository.Crud.ScoreCrudRepositorio;


@Repository
public class ScoreRepositorio {
    @Autowired
    private ScoreCrudRepositorio crud;
    
    public List<Score> getAll(){
        return (List<Score>) crud.findAll();
    }
    
    public Optional<Score> getScore(int id){
        return crud.findById(id);
    }  
  
    public Score save(Score score){
        return crud.save(score);
    }
    
    public void delete(Score score){
       crud.delete(score);
    }
}