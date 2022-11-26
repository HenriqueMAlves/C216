package br.inatel.labs.labrest.server.service;

import br.inatel.labs.labrest.server.model.Curso;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CursoService {
    private List<Curso> listaDeCursos = new ArrayList<>();

    @PostConstruct
    private void setup(){
        Curso c1 = new Curso(1L, "REST com Spring Boot", 20);
        Curso c2 = new Curso(2L, "Programação Java 11", 80);
        Curso c3 = new Curso(3L, "Dominando a IDE IntelliJ", 120);

        listaDeCursos.add(c1);
        listaDeCursos.add(c2);
        listaDeCursos.add(c3);
    }

    public List<Curso> pequisarCurso() {
        return listaDeCursos;
    }

    public Optional<Curso> buscarCursoPeloId(Long cursoId){
        Optional<Curso> opCurso = listaDeCursos.stream().filter(c -> c.getId().equals(cursoId)).findFirst();
        return opCurso;
    }
}
