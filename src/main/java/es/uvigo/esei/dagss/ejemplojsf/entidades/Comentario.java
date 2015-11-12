package es.uvigo.esei.dagss.ejemplojsf.entidades;

import java.util.Calendar;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Comentario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    private String texto;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @ManyToOne
    private Anuncio anuncio;
    
    @ManyToOne
    private Nick autor;

    public Comentario() {
        this.fecha = Calendar.getInstance().getTime();       
    }
       
    public Comentario(String texto, Anuncio anuncio, Nick autor) {
        this.texto = texto;
        this.anuncio = anuncio;
        this.autor = autor;
        this.fecha = Calendar.getInstance().getTime();       
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Anuncio getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Anuncio anuncio) {
        this.anuncio = anuncio;
    }

    public Nick getAutor() {
        return autor;
    }

    public void setAutor(Nick autor) {
        this.autor = autor;
    }

    @Override
    public String toString() {
        return "Comentario{" + "id=" + id + ", texto=" + texto + '}';
    }
}
