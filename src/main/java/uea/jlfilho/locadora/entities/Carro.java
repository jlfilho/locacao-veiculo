package uea.jlfilho.locadora.entities;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.Objects;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import uea.jlfilho.locadora.entities.enums.Cor;

@Entity
//@Table(name="tb_carro")
public class Carro implements Serializable{
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String modelo;
	private String placa;
	
	@Enumerated(EnumType.STRING)
	private Cor cor;
	private Integer ano;
	private LocalDate dataAquisicao;
	
	@JsonIgnoreProperties(value = { "carros" })
	@ManyToOne
	@JoinColumn(name="categoria_id")
	private Categoria categoria;
	
	//private Sede sede;
	
	
	//private Set<Locacao> locacoes = new HashSet<Locacao>();
	
	public Carro () {
		
	}

	public Carro(Integer id, String modelo, String placa, Cor cor, Integer ano, LocalDate dataAquisicao,
			Categoria categoria) {
		super();
		this.id = id;
		this.modelo = modelo;
		this.placa = placa;
		this.cor = cor;
		this.ano = ano;
		this.dataAquisicao = dataAquisicao;
		this.categoria = categoria;
		//this.sede = sede;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getModelo() {
		return modelo;
	}

	public void setModelo(String modelo) {
		this.modelo = modelo;
	}

	public String getPlaca() {
		return placa;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public Cor getCor() {
		return cor;
	}

	public void setCor(Cor cor) {
		this.cor = cor;
	}

	public Integer getAno() {
		return ano;
	}

	public void setAno(Integer ano) {
		this.ano = ano;
	}

	public LocalDate getDataAquisicao() {
		return dataAquisicao;
	}

	public void setDataAquisicao(LocalDate dataAquisicao) {
		this.dataAquisicao = dataAquisicao;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	/*
	 * public Sede getSede() { return sede; }
	 * 
	 * public void setSede(Sede sede) { this.sede = sede; }
	 */

	/*
	 * public Set<Locacao> getLocacoes() { return locacoes; }
	 */

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
		Carro other = (Carro) obj;
		return Objects.equals(id, other.id);
	}
	
}
