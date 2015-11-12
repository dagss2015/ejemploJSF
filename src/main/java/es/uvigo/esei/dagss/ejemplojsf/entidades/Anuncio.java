package es.uvigo.esei.dagss.ejemplojsf.entidades;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Anuncio implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String titulo;
    private String detalle;
    
    @Temporal(TemporalType.TIMESTAMP)
    private Date fecha;
    
    @ManyToOne
    private Nick nick;
    
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private List<Comentario> comentarios;

    public Anuncio() {
        this.fecha = Calendar.getInstance().getTime();       
    }
   
    public Anuncio(String titulo, String detalle, Nick nick) {
        this.titulo = titulo;
        this.detalle = detalle;
        this.nick = nick;
        this.fecha = Calendar.getInstance().getTime();       
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDetalle() {
        return detalle;
    }

    public void setDetalle(String detalle) {
        this.detalle = detalle;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Nick getNick() {
        return nick;
    }

    public void setNick(Nick nick) {
        this.nick = nick;
    }

    public List<Comentario> getComentarios() {
        return comentarios;
    }

    public void setComentarios(List<Comentario> comentarios) {
        this.comentarios = comentarios;
    }


    public void anadirComentario(Comentario comentario) {
        if (this.comentarios == null) {
            this.comentarios = new ArrayList<Comentario>();
        }
        comentario.setAnuncio(this);
        this.comentarios.add(comentario);
    }
    
    
    public void eliminarComentario(Comentario comentario) {
        if (this.comentarios != null) {
            this.comentarios.remove(comentario);
        }
    }

    @Override
    public String toString() {
        return "Anuncio{" + "id=" + id + ", titulo=" + titulo + '}';
    }

   
}


