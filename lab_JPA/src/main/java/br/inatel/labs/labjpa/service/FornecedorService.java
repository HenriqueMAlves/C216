package br.inatel.labs.labjpa.service;

import br.inatel.labs.labjpa.entity.Fornecedor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class FornecedorService {
    @PersistenceContext
    private EntityManager em;

    public Fornecedor salvar(Fornecedor f){
        f = em.merge(f);
        return f;
    }

    public Fornecedor buscaPeloId(Long id){
        Fornecedor f = em.find(Fornecedor.class, id);
        return f;
    }

    public List<Fornecedor> listar(){
        List<Fornecedor> listaFornecedor = em.createQuery("select f from Fornecedor f", Fornecedor.class).getResultList();
        return listaFornecedor;
    }

    public void remover(Fornecedor f){
        f= em.merge(f);
        em.remove(f);
    }
}
