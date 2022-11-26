package br.inatel.labs.labjpa.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Objects;

@Entity
public class Fornecedor {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@ManyToMany
	private List<Produto> listaProduto;
	@NotNull
	@NotBlank
	@Size(max = 200)
	private String razaoSocial;

	public Fornecedor(String razaoSocial) {
		super();
		this.razaoSocial = razaoSocial;
	}

    public Fornecedor() {
    }

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Produto> getListaProduto() {
		return listaProduto;
	}

	public void setListaProduto(List<Produto> listaProduto) {
		this.listaProduto = listaProduto;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	@Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Fornecedor)) return false;
        Fornecedor that = (Fornecedor) o;
        return Objects.equals(getId(), that.getId()) && Objects.equals(getListaProduto(), that.getListaProduto()) && Objects.equals(getRazaoSocial(), that.getRazaoSocial());
	}

	@Override
    public int hashCode() {
        return Objects.hash(getId(), getListaProduto(), getRazaoSocial());
	}

	@Override
	public String toString() {
		return "Fornecedor [id=" + id + ", razaoSocial=" + razaoSocial + "]";
	}
}
