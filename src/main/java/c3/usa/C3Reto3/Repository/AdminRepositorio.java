package c3.usa.C3Reto3.Repository;

import c3.usa.C3Reto3.Model.Admin;
import c3.usa.C3Reto3.Repository.Crud.AdminCrudRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class AdminRepositorio {
    @Autowired
    private AdminCrudRepositorio crud;
    
    public List<Admin> getAll(){
        return (List<Admin>) crud.findAll();
    }
    
    public Optional<Admin> getAdmin(int id){
        return crud.findById(id);
    }   
  
    public Admin save(Admin admin){
        return crud.save(admin);
    }
    
    public void delete(Admin admin){
       crud.delete(admin);
    }
}