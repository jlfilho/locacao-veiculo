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

import uea.jlfilho.locadora.entities.Cliente;
import uea.jlfilho.locadora.services.ClienteService;

@RestController
@RequestMapping(value ="/clientes")
public class ClienteResource {
	
	@Autowired
	private ClienteService clienteService; 
	
	@GetMapping
	public ResponseEntity<List<Cliente>> buscarTodos(){
		return ResponseEntity.ok().body(clienteService.buscarTodos());
	}
	
	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public ResponseEntity<Cliente> buscarPorId(@PathVariable Integer id) {
		Cliente cliente = clienteService.buscarPorId(id);
		return ResponseEntity.ok().body(cliente);
	}
	
	@PostMapping
	public ResponseEntity<Cliente> salvar(@RequestBody Cliente cliente) {
		Cliente clienteSalvo = clienteService.savar(cliente);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(clienteSalvo.getId()).toUri();
		return ResponseEntity.created(uri).body(clienteSalvo);
	} 
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		clienteService.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Cliente> atualizar(@PathVariable Integer id, 
			@RequestBody Cliente cliente) {
		Cliente clienteSalvo = clienteService.atualizar(id, cliente);
		return ResponseEntity.ok().body(clienteSalvo);
	} 

}
