package uea.jlfilho.locadora.entities;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Estado implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String nome;
	
	private Set<Cidade> cidades = new HashSet<Cidade>();
	
	public Estado() {
		
	}

	public Estado(Integer id, String nome) {
		super();
		this.id = id;
		this.nome = nome;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public Set<Cidade> getCidades() {
		return cidades;
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
		Estado other = (Estado) obj;
		return Objects.equals(id, other.id);
	}

	

}
