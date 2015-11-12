package es.uvigo.esei.dagss.ejemplojsf.daos;

import es.uvigo.esei.dagss.ejemplojsf.entidades.Anuncio;
import es.uvigo.esei.dagss.ejemplojsf.entidades.Comentario;
import es.uvigo.esei.dagss.ejemplojsf.entidades.Nick;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

@Stateless
public class AnuncioDAO {

    @PersistenceContext(unitName = "ejemploJSF_PU")
    private EntityManager em;

    public Anuncio crear(Anuncio anuncio) {
        em.persist(anuncio);
        return anuncio;
    }

    public Anuncio actualizar(Anuncio anuncio) {
        return em.merge(anuncio);
    }

    public Anuncio anadirComentsrio(Anuncio anuncio, Comentario comentario) {
        anuncio.anadirComentario(comentario);
        return em.merge(anuncio);        
    }

    public void borrar(Anuncio anuncio) {
        em.remove(em.merge(anuncio));
    }

    public Anuncio buscarPorId(Long id) {
        return em.find(Anuncio.class, id);
    }

    public List<Nick> buscarTodos() {
        Query q = em.createQuery("SELECT object(a) FROM Anuncio AS a");
        return q.getResultList();
    }

    public List<Anuncio> buscarPorNick(Nick nick) {
        Query q = em.createQuery("SELECT object(a) FROM Anuncio AS n WHERE a.nick.id = :nick_id");
        q.setParameter("nick_id", nick.getId());
        return q.getResultList();
    }

    public List<Anuncio> buscarPorTexto(String patron) {
        Query q = em.createQuery("SELECT object(a) FROM Anuncio AS a "
                + "   WHERE (a.titulo LIKE :patronTitulo) OR "
                + "         (a.detalle LIKE :patronDetalle)");

        q.setParameter("patronTitulo", "%" + patron + "%");
        q.setParameter("patronDetalle", "%" + patron + "%");
        return q.getResultList();
    }

}
