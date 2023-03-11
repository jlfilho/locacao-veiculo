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

import uea.jlfilho.locadora.entities.Locacao;
import uea.jlfilho.locadora.services.LocacaoService;

@RestController
@RequestMapping(value ="/locacoes")
public class LocacaoResource {
	
	@Autowired
	private LocacaoService locacaoService; 
	
	@GetMapping
	public ResponseEntity<List<Locacao>> buscarTodos(){
		return ResponseEntity.ok().body(locacaoService.buscarTodos());
	}
	
	@RequestMapping(value = "/{id}", method= RequestMethod.GET)
	public ResponseEntity<Locacao> buscarPorId(@PathVariable Integer id) {
		Locacao locacao = locacaoService.buscarPorId(id);
		return ResponseEntity.ok().body(locacao);
	}
	
	@PostMapping
	public ResponseEntity<Locacao> salvar(@RequestBody Locacao locacao) {
		Locacao locacaoSalvo = locacaoService.savar(locacao);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(locacaoSalvo.getId()).toUri();
		return ResponseEntity.created(uri).body(locacaoSalvo);
	} 
	
	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> excluir(@PathVariable Integer id) {
		locacaoService.excluir(id);
		return ResponseEntity.noContent().build();
	}
	
	@PutMapping("/{id}")
	public ResponseEntity<Locacao> atualizar(@PathVariable Integer id, 
			@RequestBody Locacao locacao) {
		Locacao locacaoSalvo = locacaoService.atualizar(id, locacao);
		return ResponseEntity.ok().body(locacaoSalvo);
	} 

}
