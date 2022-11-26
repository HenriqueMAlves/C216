package br.inatel.labs.labrest.server;

import br.inatel.labs.labrest.server.model.Curso;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.reactive.server.WebTestClient;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CursoControllerTest {

    @Autowired
    private WebTestClient webTestClient;

    @Test
    void deveListartCursos(){
        webTestClient.get().uri("/curso").exchange()
                .expectStatus().isOk()
                .expectBody().returnResult();
    }

    @Test
    void dadoIdCursoValido_quandoBuscaPorId_devolveCursoVálido() {
        Long cursoIdValido = 1l;
        Curso curso = webTestClient.get().uri("/curso/" + cursoIdValido).exchange().expectStatus().isOk()
                .expectBody(Curso.class).returnResult().getResponseBody();
        assertNotNull(curso);
        assertEquals(cursoIdValido, curso.getId());
    }

    @Test
    void dadoIdCursoInvalido_quandoBuscaPorId_devolveErroDeNaoEncontrado() {
        Long cursoIdValido = 100l;
        webTestClient.get().uri("/curso/" + cursoIdValido).exchange().expectStatus().isNotFound();
    }

    @Test
    void dadoCursoValido_quandoInsereCurso_devolveCursoCriado() {
        Curso novoCurso = new Curso();
        novoCurso.setCargaHoraria(20);
        novoCurso.setDescricao("Curso de Testes");
        Curso curso = webTestClient.post().uri("/curso").bodyValue(novoCurso).exchange().expectStatus().isCreated()
                .expectBody(Curso.class).returnResult().getResponseBody();

        assertNotNull(curso);
        assertEquals(novoCurso.getCargaHoraria(), curso.getCargaHoraria());
        assertEquals(novoCurso.getDescricao(), curso.getDescricao());
    }

    @Test
    void dadoCursoValido_quandoEditaCurso_devolveSucessoAoEditar() {
        Curso cursoASerEditado = new Curso();
        cursoASerEditado.setId(2l);
        cursoASerEditado.setDescricao("Nova Descrição");
        cursoASerEditado.setCargaHoraria(50);

        webTestClient.put().uri("/curso").bodyValue(cursoASerEditado).exchange().expectStatus().isNoContent()
                .expectBody().returnResult();
    }

    @Test
    void dadoCursoIdValido_quandoDeletaCurso_devolveSucessoAoDeletar() {
        Long cursoIdValido = 3l;
        webTestClient.delete().uri("/curso/" + cursoIdValido).exchange().expectStatus().isNoContent().expectBody()
                .returnResult();
    }
}
