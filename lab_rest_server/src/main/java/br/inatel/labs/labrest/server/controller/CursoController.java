package br.inatel.labs.labrest.server.controller;

import br.inatel.labs.labrest.server.model.Curso;
import br.inatel.labs.labrest.server.service.CursoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/curso")
public class CursoController {
    @Autowired
    private CursoService servico;

    @GetMapping
    public List<Curso> listar(){
        List<Curso> listaCurso = servico.pequisarCurso();
        return listaCurso;
    }
}
