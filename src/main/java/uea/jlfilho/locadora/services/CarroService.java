package uea.jlfilho.locadora.services;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uea.jlfilho.locadora.entities.Carro;
import uea.jlfilho.locadora.repositories.CarroRepository;
import uea.jlfilho.locadora.repositories.CategoriaRepository;

@Service
public class CarroService {

	@Autowired
	private CarroRepository carroRepository;
	@Autowired
	private CategoriaRepository categoriaRepository;

	public List<Carro> buscarTodos() {
		return carroRepository.findAll();
	}

	public Carro buscarPorId(Integer id) {
		Optional<Carro> carroSalva = carroRepository.findById(id);
		return carroSalva.get();
	}

	public Carro savar(Carro carro) {
		if (categoriaRepository.findById(carro.getCategoria().getId()).get() == null) {
			throw new NoSuchElementException();
		}
		Carro carroSalva = carroRepository.save(carro);
		return carroSalva;
	}

	public void excluir(Integer id) {
		carroRepository.deleteById(id);
	}

	public Carro atualizar(Integer id, Carro carro) {
		categoriaRepository.findById(carro.getCategoria().getId()).orElseThrow(
				() -> new NoSuchElementException());
		carroRepository.findById(id).orElseThrow(() -> new NoSuchElementException());

		/*
		 * if (categoriaRepository.findById(carro.getCategoria().getId()).get() == null
		 * || carroRepository.findById(id).get() == null) { throw new
		 * NoSuchElementException(); }
		 */

		Carro carroSalva = carroRepository.getReferenceById(id);
		copyCarro(carro, carroSalva);
		Carro novaCarroSalva = carroRepository.save(carroSalva);
		return novaCarroSalva;
	}

	private void copyCarro(Carro carro, Carro carroSalvo) {
		if (carro.getModelo() != null) {
			carroSalvo.setModelo(carro.getModelo());
		}
		if (carro.getPlaca() != null) {
			carroSalvo.setPlaca(carro.getPlaca());
		}
		if (carro.getCor() != null) {
			carroSalvo.setCor(carro.getCor());
		}
		if (carro.getAno() != null) {
			carroSalvo.setAno(carro.getAno());
		}
		if (carro.getDataAquisicao() != null) {
			carroSalvo.setDataAquisicao(carro.getDataAquisicao());
		}
		if (carro.getCategoria() != null) {
			carroSalvo.setCategoria(carro.getCategoria());
		}

	}

}
