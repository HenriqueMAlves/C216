package br.inatel.labs.labrest.server.model;

public class Curso {
    private Long id;
    private String descricao;
    private Integer cargaHoraria;

    public Curso(Long id, String descricao, Integer cargaHoraria) {
        this.id = id;
        this.descricao = descricao;
        this.cargaHoraria = cargaHoraria;
    }

    public Curso() {
    }
}
