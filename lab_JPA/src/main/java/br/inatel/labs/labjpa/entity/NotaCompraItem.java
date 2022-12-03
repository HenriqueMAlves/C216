package br.inatel.labs.labjpa.entity;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class NotaCompraItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToOne
	private NotaCompra notaCompra;
	@ManyToOne
	private Produto produto;
	@NotNull
	@Positive
	private BigDecimal valorCompraProduto;
	@NotNull
	@Positive
	private Integer quantidade;

	public NotaCompraItem(NotaCompra notaCompra, Produto produto, BigDecimal valorCompraProduto, Integer quantidade) {
		super();
		this.notaCompra = notaCompra;
		this.produto = produto;
		this.valorCompraProduto = valorCompraProduto;
		this.quantidade = quantidade;
	}

    public NotaCompraItem() {
    }

    public BigDecimal getCalculoTotalItem(){
		return valorCompraProduto.multiply(BigDecimal.valueOf(quantidade));
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public NotaCompra getNotaCompra() {
		return notaCompra;
	}

	public void setNotaCompra(NotaCompra notaCompra) {
		this.notaCompra = notaCompra;
	}

	public Produto getProduto() {
		return produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	public BigDecimal getValorCompraProduto() {
		return valorCompraProduto;
	}

	public void setValorCompraProduto(BigDecimal valorCompraProduto) {
		this.valorCompraProduto = valorCompraProduto;
	}

	public Integer getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Integer quantidade) {
		this.quantidade = quantidade;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof NotaCompraItem)) return false;
        NotaCompraItem that = (NotaCompraItem) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getNotaCompra(), that.getNotaCompra()) && Objects.equals(getProduto(), that.getProduto()) && Objects.equals(getValorCompraProduto(), that.getValorCompraProduto()) && Objects.equals(getQuantidade(), that.getQuantidade());
	}

	@Override
    public int hashCode() {
        return Objects.hash(getId(), getNotaCompra(), getProduto(), getValorCompraProduto(), getQuantidade());
	}

	@Override
	public String toString() {
		return "NotaCompraItem [id=" + id + ", valorCompraProduto=" + valorCompraProduto + ", quantidade=" + quantidade
				+ "]";
	}
}
