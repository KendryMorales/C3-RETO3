package c3.usa.C3Reto3.Model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author KENDRY
 */

@Entity
@Table(name = "cabin")
@JsonPropertyOrder({"id", "name", "brand","rooms", "description","category", "messages", "reservations"})
public class Cabin implements Serializable{
    @Id
    //Para id auto generado0
    /**
     * 
     */
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id; 
    /**
     * 
     */
    @Column(length = 45)   
    private String name;   
    /**
     * 
     */
    @Column(length = 45)   
    private String brand;    
    /**
     * 
     */
    private Integer rooms;
    /**
     * 
     */
    @Column(length = 250)       
    private String description;    

    //Relacion con la tabla categoria, traer nombre
    /**
     * 
     */
    @ManyToOne
    @JoinColumn(name = "category_cabin")
    @JsonIgnoreProperties("cabins")
    private Categoria category;    
    
    /**
     * 
     */
    //Relaciones agregadas hoy en tutoria
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "cabin")
    @JsonIgnoreProperties({"cabin", "client"})
    private List<Mensaje> messages;

    /**
     * 
     */
    @OneToMany(cascade = {CascadeType.PERSIST},mappedBy = "cabin")
    @JsonIgnoreProperties({"cabin", "client"})
    private List<Reserva> reservations;

    /**
     * 
     * @return 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @return 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name 
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return 
     */
    public String getBrand() {
        return brand;
    }

    /**
     * 
     * @param brand 
     */
    public void setBrand(String brand) {
        this.brand = brand;
    }

    /**
     * 
     * @return 
     */
    public Integer getRooms() {
        return rooms;
    }

    /**
     * 
     * @param rooms 
     */
    public void setRooms(Integer rooms) {
        this.rooms = rooms;
    }

    /***
     * 
     * @return 
     */
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description 
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return 
     */
    public Categoria getCategory() {
        return category;
    }

    /**
     * 
     * @param category 
     */
    public void setCategory(Categoria category) {
        this.category = category;
    }

    /**
     * 
     * @return 
     */
    public List<Mensaje> getMessages() {
        return messages;
    }

    /**
     * 
     * @param messages 
     */
    public void setMessages(List<Mensaje> messages) {
        this.messages = messages;
    }

    /**
     * 
     * @return 
     */
    public List<Reserva> getReservations() {
        return reservations;
    }

    /**
     * 
     * @param reservations 
     */
    public void setReservations(List<Reserva> reservations) {
        this.reservations = reservations;
    }    
}

//modelo tabla, relaciones