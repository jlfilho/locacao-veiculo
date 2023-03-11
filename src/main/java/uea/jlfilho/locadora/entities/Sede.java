package uea.jlfilho.locadora.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import uea.jlfilho.locadora.entities.primitive.Localidade;

public class Sede implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer codigo;
	private Localidade localidade;
	
	private Endereco endereco;
	
	private Set<Locacao> locacoes = new HashSet<Locacao>();
	private Set<Carro> carros = new HashSet<Carro>();
	
	public Sede() {
		
	}

	public Sede(Integer codigo, Localidade localidade, Endereco endereco) {
		super();
		this.codigo = codigo;
		this.localidade = localidade;
		this.endereco = endereco;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public Localidade getLocalidade() {
		return localidade;
	}

	public void setLocalidade(Localidade localidade) {
		this.localidade = localidade;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Set<Locacao> getLocacoes() {
		return locacoes;
	}

	

	public Set<Carro> getCarros() {
		return carros;
	}

	@Override
	public int hashCode() {
		return Objects.hash(codigo);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Sede other = (Sede) obj;
		return Objects.equals(codigo, other.codigo);
	}
	


}
