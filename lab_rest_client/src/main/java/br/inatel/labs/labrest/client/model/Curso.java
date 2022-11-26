package br.inatel.labs.labrest.client.model;

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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public Integer getCargaHoraria() {
        return cargaHoraria;
    }

    public void setCargaHoraria(Integer cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }
}
