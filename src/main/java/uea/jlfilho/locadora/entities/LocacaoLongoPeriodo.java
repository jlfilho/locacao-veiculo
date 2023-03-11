package uea.jlfilho.locadora.entities;

import java.time.Instant;

public class LocacaoLongoPeriodo extends Locacao {
	private Double porcentagemDesconto;
	
	public LocacaoLongoPeriodo () {
		super();
	}

	public LocacaoLongoPeriodo(Integer id, Instant dataRetirada, Instant dataDevolucao, Sede sedeRetirada, Carro carro,
			Cliente cliente, Double porcentagemDesconto) {
		super(id, dataRetirada, dataDevolucao, sedeRetirada, carro, cliente);
		this.porcentagemDesconto = porcentagemDesconto;
	}

	public Double getPorcentagemDesconto() {
		return porcentagemDesconto;
	}

	public void setPorcentagemDesconto(Double porcentagemDesconto) {
		this.porcentagemDesconto = porcentagemDesconto;
	}
	
	
	

}
