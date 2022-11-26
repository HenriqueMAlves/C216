package br.inatel.labs.labjpa.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
public class Produto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToMany
    private List<Fornecedor> listaFornecedor;
    @NotNull
    @NotBlank
    @Size(max = 100)
    private String descricao;

    public Produto(String descricao) {
        this.descricao = descricao;
    }

    public Produto() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Fornecedor> getListaFornecedor() {
        return listaFornecedor;
    }

    public void setListaFornecedor(List<Fornecedor> listaFornecedor) {
        this.listaFornecedor = listaFornecedor;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Produto)) return false;
        Produto produto = (Produto) o;
        return Objects.equals(getId(), produto.getId()) && Objects.equals(getListaFornecedor(), produto.getListaFornecedor()) && Objects.equals(getDescricao(), produto.getDescricao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getListaFornecedor(), getDescricao());
    }

    @Override
    public String toString() {
        return "Produto{" +
                "id=" + id +
                ", listaFornecedor=" + listaFornecedor +
                ", descricao='" + descricao + '\'' +
                '}';
    }
}
