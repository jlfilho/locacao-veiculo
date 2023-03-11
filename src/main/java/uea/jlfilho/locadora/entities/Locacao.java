package uea.jlfilho.locadora.entities;

import java.io.Serializable;
import java.time.Instant;
import java.util.Objects;

public class Locacao implements Serializable{
	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private Instant dataRetirada;
	private Instant dataDevolucao;
	
	private Sede sedeRetirada;
	private Carro carro;
	private Cliente cliente;
	
	public Locacao () {
		
	}

	public Locacao(Integer id, Instant dataRetirada, Instant dataDevolucao, Sede sedeRetirada, Carro carro,
			Cliente cliente) {
		super();
		this.id = id;
		this.dataRetirada = dataRetirada;
		this.dataDevolucao = dataDevolucao;
		this.sedeRetirada = sedeRetirada;
		this.carro = carro;
		this.cliente = cliente;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Instant getDataRetirada() {
		return dataRetirada;
	}

	public void setDataRetirada(Instant dataRetirada) {
		this.dataRetirada = dataRetirada;
	}

	public Instant getDataDevolucao() {
		return dataDevolucao;
	}

	public void setDataDevolucao(Instant dataDevolucao) {
		this.dataDevolucao = dataDevolucao;
	}

	public Sede getSedeRetirada() {
		return sedeRetirada;
	}

	public void setSedeRetirada(Sede sedeRetirada) {
		this.sedeRetirada = sedeRetirada;
	}

	public Carro getCarro() {
		return carro;
	}

	public void setCarro(Carro carro) {
		this.carro = carro;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
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
		Locacao other = (Locacao) obj;
		return Objects.equals(id, other.id);
	}
	
	
	

}
