package uea.jlfilho.locadora.resources;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import uea.jlfilho.locadora.entities.Categoria;
import uea.jlfilho.locadora.services.CategoriaService;

@RestController
@RequestMapping(value ="/categorias")
public class CategoriaResource {
	
	@Autowired
	private CategoriaService categoriaService; 
	
	@GetMapping
	public List<Categoria> buscarTodos(){
		return categoriaService.buscarTodos();
	}
	
	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public ResponseEntity<Categoria> buscarPorId(@PathVariable Integer id) {
		Categoria categoria = categoriaService.buscarPorId(id);
		return categoria != null ? ResponseEntity.ok().body(categoria) :
			ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Categoria> salvar(@RequestBody Categoria categoria) {
		Categoria categoriaSalva = categoriaService.savar(categoria);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(categoriaSalva.getId()).toUri();
		return ResponseEntity.created(uri).body(categoriaSalva);
	} 
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		categoriaService.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Categoria> atualizar(@PathVariable Integer id, 
			@RequestBody Categoria categoria) {
		Categoria categoriaSalva = categoriaService.atualizar(id, categoria);
		return ResponseEntity.ok().body(categoriaSalva);
	} 
	
	
	

}
