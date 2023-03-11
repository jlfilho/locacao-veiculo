package uea.jlfilho.locadora.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uea.jlfilho.locadora.entities.Locacao;
import uea.jlfilho.locadora.repositories.CarroRepository;
import uea.jlfilho.locadora.repositories.ClienteRepository;
import uea.jlfilho.locadora.repositories.LocacaoRepository;

@Service
public class LocacaoService {

	@Autowired
	private LocacaoRepository locacaoRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private CarroRepository carroRepository;

	public List<Locacao> buscarTodos() {
		return locacaoRepository.findAll();
	}

	public Locacao buscarPorId(Integer id) {
		Optional<Locacao> locacaoSalva = locacaoRepository.findById(id);
		return locacaoSalva.orElseThrow();
	}

	public Locacao savar(Locacao locacao) {
		clienteRepository.findById(locacao.getCliente().getId()).orElseThrow();
		carroRepository.findById(locacao.getCarro().getId()).orElseThrow();

		Locacao locacaoSalva = locacaoRepository.save(locacao);
		return locacaoSalva;
	}

	public void excluir(Integer id) {
		locacaoRepository.deleteById(id);
	}

	public Locacao atualizar(Integer id, Locacao locacao) {
		clienteRepository.findById(locacao.getCliente().getId()).orElseThrow();
		carroRepository.findById(locacao.getCarro().getId()).orElseThrow();
		locacaoRepository.findById(id).orElseThrow();

		Locacao locacaoSalva = locacaoRepository.getReferenceById(id);
		copyLocacao(locacao, locacaoSalva);
		Locacao novaLocacaoSalva = locacaoRepository.save(locacaoSalva);
		return novaLocacaoSalva;
	}

	private void copyLocacao(Locacao locacao, Locacao locacaoSalvo) {
		if (locacao.getDataRetirada() != null) {
			locacaoSalvo.setDataRetirada(locacao.getDataRetirada());
		}
		if (locacao.getDataDevolucao() != null) {
			locacaoSalvo.setDataDevolucao(locacao.getDataDevolucao());
		}
		if (locacao.getCliente() != null) {
			locacaoSalvo.setCliente(locacao.getCliente());
		}
		if (locacao.getCarro() != null) {
			locacaoSalvo.setCarro(locacao.getCarro());
		}

	}

}
