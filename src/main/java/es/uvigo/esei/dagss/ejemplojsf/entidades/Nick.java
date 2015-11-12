package es.uvigo.esei.dagss.ejemplojsf.entidades;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Nick {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nick;
    private String nombre;
    
    @Temporal(TemporalType.DATE)
    private Date fechaNacimiento;
    
    @Temporal(TemporalType.TIMESTAMP)   
    private Date creacion;

    public Nick() {
        this.creacion = Calendar.getInstance().getTime();
    }
       
    public Nick(String nick, String nombre, Date fechaNacimiento) {
        this.nick = nick;
        this.nombre = nombre;
        this.fechaNacimiento = fechaNacimiento;
        this.creacion = Calendar.getInstance().getTime();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public Date getCreacion() {
        return creacion;
    }

    public void setCreacion(Date creacion) {
        this.creacion = creacion;
    }

    @Override
    public String toString() {
        return "Nick{" + "id=" + id + ", nick=" + nick + '}';
    }
    
    

}
