package br.inatel.labs.labjpa.service;

import br.inatel.labs.labjpa.entity.Produto;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class ProdutoService {
    @PersistenceContext
    private EntityManager em;

    public Produto salvar(Produto p){
        p = em.merge(p);
        return p;
    }

    public Produto buscarPeloId(Long id){
        Produto p = em.find(Produto.class, id);
        return p;
    }

    public List<Produto> listar(){
        return em.createQuery("select p from Produto p", Produto.class).getResultList();
    }

    public void remover(Produto p){
        p = em.merge(p);
        em.remove(p);
    }
}
