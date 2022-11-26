package br.inatel.labs.labjpa.service;

import br.inatel.labs.labjpa.entity.NotaCompra;
import br.inatel.labs.labjpa.entity.NotaCompraItem;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class NotaCompraService {
    @PersistenceContext
    private EntityManager em;

    // Nota Compra
    public NotaCompra salvarNotaCompra(NotaCompra nota){
        return em.merge(nota);
    }

    public NotaCompra buscarNotaCompraPeloId(Long id){
        return em.find(NotaCompra.class, id);
    }

    public NotaCompra buscarNotaCompraPeloIdComListaItem(Long id){
        NotaCompra nota = em.find(NotaCompra.class, id);
        nota.getListaNotaCompraItem().size();
        return nota;
    }

    public List<NotaCompra> listarNotaCompra(){
        return em.createQuery("select n from NotaCompra n", NotaCompra.class).getResultList();
    }

    // Nota Compra Item
    public NotaCompraItem salvarNotaCompraItem(NotaCompraItem item){
        return em.merge(item);
    }

    public NotaCompraItem buscarNotaCompraItemPeloId(Long id){
        return em.find(NotaCompraItem.class, id);
    }

    public List<NotaCompraItem> listarNotaCompraItem(){
        return em.createQuery("select i from NotaCompraItem i", NotaCompraItem.class).getResultList();
    }
}
