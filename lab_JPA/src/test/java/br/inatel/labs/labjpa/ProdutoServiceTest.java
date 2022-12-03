package br.inatel.labs.labjpa;

import br.inatel.labs.labjpa.entity.Produto;
import br.inatel.labs.labjpa.service.ProdutoService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
@ActiveProfiles("test")
public class ProdutoServiceTest {
    @Autowired
    private ProdutoService service;

    @Test
    void dadoIdValido_quandoInvocaBuscarPeloId_entaoProdutoRetornadoEhValido(){
        Long idValido = 1L;

        Produto produtoEncontrado = service.buscarPeloId(idValido);

        assertFalse(produtoEncontrado == null);
        assertFalse(produtoEncontrado.getDescricao().isBlank());
        assertEquals(idValido, produtoEncontrado.getId());
    }
}
