package es.uvigo.esei.dagss.ejemplojsf.controladores;

import es.uvigo.esei.dagss.ejemplojsf.daos.NickDAO;
import es.uvigo.esei.dagss.ejemplojsf.entidades.Nick;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;

@Named(value = "nickControlador")
@SessionScoped
public class NickControlador implements Serializable {

    @Inject
    private NickDAO nickDAO;

    private List<Nick> nicks;
    private Nick nickActual;
    private String nombreNick;

    public NickControlador() {
    }

    public List<Nick> getNicks() {
        return nicks;
    }

    public void setNicks(List<Nick> nicks) {
        this.nicks = nicks;
    }

    public Nick getNickActual() {
        return nickActual;
    }

    public void setNickActual(Nick nickActual) {
        this.nickActual = nickActual;
    }

    public String getNombreNick() {
        return nombreNick;
    }

    public void setNombreNick(String nombreNick) {
        this.nombreNick = nombreNick;
    }

    @PostConstruct
    public void inicializarDatosControlador() {
        nicks = nickDAO.buscarTodos();
        nickActual = actualizarNickActual();
    }

    private Nick actualizarNickActual() {
        if ((nicks != null) && (nicks.size() > 0)) {
            return nicks.get(0);
        } else {
            return null;
        }
    }

    public String doCrearNuevoNick() {
        this.nickActual = new Nick();
        return "nuevo_nick";
    }

    public String doCancelarNuevoNick() {
        actualizarNickActual();
        return "listado_nicks";
    }

    public String doGuardarNuevoNick() {
        nickDAO.crear(nickActual);
        nicks = nickDAO.buscarTodos(); // Refrescar listado
        actualizarNickActual();

        return "listado_nicks";
    }
    
    public String doBuscarNombreNick() {
        nicks = nickDAO.buscarPorNombre(nombreNick);
        actualizarNickActual();

        return "listado_nick";
    }
    
    public String doSeleccionarNick(Nick nick) {
        nickActual = nick;
        
        return "listado_nicks";
    }
    
    public String doVerAnuncios(Nick nick) {
        nickActual = nick;
        
        return "listado_anuncios";
    }

}
