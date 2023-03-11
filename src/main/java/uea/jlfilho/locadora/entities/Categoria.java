package uea.jlfilho.locadora.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categoria implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String descreicao;
	private Double precoDiaria;
	
	@JsonIgnoreProperties(value = { "categoria" })
	@OneToMany(mappedBy = "categoria")
	private Set<Carro> carros = new HashSet<Carro>();

	public Categoria() {

	}
	
	public Categoria(Integer id) {
		super();
		this.id = id;
	}

	public Categoria(Integer id, String descreicao, Double precoDiaria) {
		super();
		this.id = id;
		this.descreicao = descreicao;
		this.precoDiaria = precoDiaria;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescreicao() {
		return descreicao;
	}

	public void setDescreicao(String descreicao) {
		this.descreicao = descreicao;
	}

	public Double getPrecoDiaria() {
		return precoDiaria;
	}

	public void setPrecoDiaria(Double precoDiaria) {
		this.precoDiaria = precoDiaria;
	}

	public Set<Carro> getCarros() {
		return carros;
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Categoria other = (Categoria) obj;
		return Objects.equals(id, other.id);
	}

}
