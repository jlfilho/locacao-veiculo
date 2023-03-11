package uea.jlfilho.locadora.entities;

import java.time.Instant;

public class LocacaoDiaria extends Locacao {
	private Integer diasPrevistoDevolucao;
	
	public LocacaoDiaria () {
		super();
	}

	public LocacaoDiaria(Integer id, Instant dataRetirada, Instant dataDevolucao, Sede sedeRetirada, Carro carro,
			Cliente cliente, Integer diasPrevistoDevolucao) {
		super(id, dataRetirada, dataDevolucao, sedeRetirada, carro, cliente);
		this.diasPrevistoDevolucao = diasPrevistoDevolucao;
	}

	public Integer getDiasPrevistoDevolucao() {
		return diasPrevistoDevolucao;
	}

	public void setDiasPrevistoDevolucao(Integer diasPrevistoDevolucao) {
		this.diasPrevistoDevolucao = diasPrevistoDevolucao;
	}
	
	
	

}
