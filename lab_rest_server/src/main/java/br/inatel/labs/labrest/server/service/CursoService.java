package br.inatel.labs.labrest.server.service;

import br.inatel.labs.labrest.server.model.Curso;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CursoService {
    private List<Curso> listaDeCursos = new ArrayList<>();

    public List<Curso> pequisarCurso() {
        return listaDeCursos;
    }
}
