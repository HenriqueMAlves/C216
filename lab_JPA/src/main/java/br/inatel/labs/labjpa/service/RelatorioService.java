package br.inatel.labs.labjpa.service;

import br.inatel.labs.labjpa.dto.TotalCompradoPorFornecedorDTO;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

@Service
public class RelatorioService {
    @PersistenceContext
    private EntityManager em;

    public List<TotalCompradoPorFornecedorDTO> pesquisarTotalCompradoPorFornecedor() {
        String query = " SELECT new br.inatel.labs.labjpa.dto.TotalCompradoPorFornecedorDTO "
                + "	( f.razaoSocial "
                + " , SUM( i.quantidade * i.valorCompraProduto )"
                + " ) "
                + " FROM NotaCompraItem i "
                + " JOIN i.notaCompra n "
                + " JOIN n.fornecedor f "
                + " GROUP BY f.razaoSocial ";

        return em.createQuery(query, TotalCompradoPorFornecedorDTO.class).getResultList();
    }
}
