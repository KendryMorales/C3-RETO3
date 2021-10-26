package c3.usa.C3Reto3.Service;

import c3.usa.C3Reto3.Model.Admin;
import c3.usa.C3Reto3.Repository.AdminRepositorio;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServicioAdmin {
    @Autowired
    private AdminRepositorio metodosCrud;
 
    public List<Admin> getAll(){
       return metodosCrud.getAll();
    }
    
        public Optional<Admin> getAdmin(int adminId) {
        return metodosCrud.getAdmin(adminId);
    }
    
    public Admin save(Admin admin) {
        if (admin.getIdAdmin() == null) {
            return metodosCrud.save(admin);
        } else {
            Optional<Admin> e= metodosCrud.getAdmin(admin.getIdAdmin());
            if (e.isEmpty()) {
                return metodosCrud.save(admin);
            } else {
                return admin;
            }
        }
    }
    
        public Admin update(Admin admin){
        if(admin.getIdAdmin()!=null){
            Optional<Admin> e= metodosCrud.getAdmin(admin.getIdAdmin());
            if(!e.isEmpty()){
                if(admin.getEmail()!=null){
                    e.get().setEmail(admin.getEmail());
                }
                if(admin.getPassword()!=null){
                    e.get().setPassword(admin.getPassword());
                }
                if(admin.getName()!=null){
                    e.get().setName(admin.getName());
                }
                metodosCrud.save(e.get());
                return e.get();
            }else{
                return admin;
            }
        }else{
            return admin;
        }
    }

    public boolean deleteAdmin(int adminId) {
        Boolean aBoolean = getAdmin(adminId).map(admin -> {
            metodosCrud.delete(admin);
            return true;
        }).orElse(false);
        return aBoolean;
    }
}
