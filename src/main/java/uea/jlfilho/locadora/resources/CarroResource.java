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

import uea.jlfilho.locadora.entities.Carro;
import uea.jlfilho.locadora.services.CarroService;

@RestController
@RequestMapping(value ="/carros")
public class CarroResource {
	
	@Autowired
	private CarroService carroService; 
	
	@GetMapping
	public ResponseEntity<List<Carro>> buscarTodos(){
		return ResponseEntity.ok().body(carroService.buscarTodos());
	}
	
	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public ResponseEntity<Carro> buscarPorId(@PathVariable Integer id) {
		Carro carro = carroService.buscarPorId(id);
		return carro != null ? ResponseEntity.ok().body(carro) :
			ResponseEntity.notFound().build();
	}
	
	@PostMapping
	public ResponseEntity<Carro> salvar(@RequestBody Carro carro) {
		Carro carroSalva = carroService.savar(carro);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(carroSalva.getId()).toUri();
		return ResponseEntity.created(uri).body(carroSalva);
	} 
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		carroService.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Carro> atualizar(@PathVariable Integer id, 
			@RequestBody Carro carro) {
		Carro carroSalva = carroService.atualizar(id, carro);
		return ResponseEntity.ok().body(carroSalva);
	} 
	
	
	

}
