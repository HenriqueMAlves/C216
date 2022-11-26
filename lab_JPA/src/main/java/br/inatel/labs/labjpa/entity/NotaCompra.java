package br.inatel.labs.labjpa.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

@Entity
public class NotaCompra {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @OneToMany(mappedBy = "notaCompra")
    private List<NotaCompraItem> listaNotaCompraItem;
    @ManyToOne
    private Fornecedor fornecedor;
    @NotNull
    @Past
    private LocalDate dataEmissao;

    public BigDecimal getCalculoTotalNota(){
        BigDecimal total = this.listaNotaCompraItem.stream()
                .map(i -> i.getCalculoTotalItem())
                .reduce(BigDecimal.ZERO, BigDecimal::add);

        return total;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<NotaCompraItem> getListaNotaCompraItem() {
        return listaNotaCompraItem;
    }

    public void setListaNotaCompraItem(List<NotaCompraItem> listaNotaCompraItem) {
        this.listaNotaCompraItem = listaNotaCompraItem;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public LocalDate getDataEmissao() {
        return dataEmissao;
    }

    public void setDataEmissao(LocalDate dataEmissao) {
        this.dataEmissao = dataEmissao;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NotaCompra)) return false;
        NotaCompra that = (NotaCompra) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getListaNotaCompraItem(), that.getListaNotaCompraItem()) && Objects.equals(getFornecedor(), that.getFornecedor()) && Objects.equals(getDataEmissao(), that.getDataEmissao());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getListaNotaCompraItem(), getFornecedor(), getDataEmissao());
    }

    @Override
    public String toString() {
        return "NotaCompra{" +
                "id=" + id +
                ", listaNotaCompraItem=" + listaNotaCompraItem +
                ", fornecedor=" + fornecedor +
                ", dataEmissao=" + dataEmissao +
                '}';
    }
}
