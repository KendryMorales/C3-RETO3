package c3.usa.C3Reto3.Reportes;

import c3.usa.C3Reto3.Model.Cliente;

/**
 *
 * @author KENDRY
 */
public class ContadorClientes {
    private Long total;
    private Cliente client;
    
    public ContadorClientes(Long total, Cliente client){
        this.total = total;
        this.client = client;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public Cliente getClient() {
        return client;
    }

    public void setClient(Cliente client) {
        this.client = client;
    }
       
}
