package uea.jlfilho.locadora.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uea.jlfilho.locadora.entities.Categoria;
import uea.jlfilho.locadora.repositories.CategoriaRepository;

@Service
public class CategoriaService {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	public List<Categoria> buscarTodos () {
		return categoriaRepository.findAll();
	}
	
	public Categoria buscarPorId(Integer id) {
		Optional<Categoria> categoriaSalva = categoriaRepository.findById(id);
		return categoriaSalva.get();
	}
	
	public Categoria savar(Categoria categoria) {
		Categoria categoriaSalva = categoriaRepository.save(categoria);
		return categoriaSalva;
	}
	
	public void excluir(Integer id) {
		categoriaRepository.deleteById(id);
	}
	
	public Categoria atualizar(Integer id, Categoria categoria) {
		Categoria categoriaSalva = categoriaRepository.getReferenceById(id);
		BeanUtils.copyProperties(categoria, categoriaSalva, "id");
		Categoria novaCategoriaSalva = categoriaRepository.save(categoriaSalva);
		return novaCategoriaSalva;
	}
	
	

}
