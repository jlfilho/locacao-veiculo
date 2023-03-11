package uea.jlfilho.locadora.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import uea.jlfilho.locadora.entities.Cliente;
import uea.jlfilho.locadora.repositories.ClienteRepository;

@Service
public class ClienteService {

	@Autowired
	private ClienteRepository clienteRepository;
	

	public List<Cliente> buscarTodos() {
		return clienteRepository.findAll();
	}

	public Cliente buscarPorId(Integer id) {
		Optional<Cliente> clienteSalvo = clienteRepository.findById(id);
		return clienteSalvo.orElseThrow();
	}

	public Cliente savar(Cliente cliente) {
		Cliente clienteSalvo = clienteRepository.save(cliente);
		return clienteSalvo;
	}

	public void excluir(Integer id) {
		clienteRepository.deleteById(id);
	}

	public Cliente atualizar(Integer id, Cliente cliente) {
		Cliente clienteSalvo = clienteRepository.findById(id).orElseThrow();
		
		copyCliente(cliente, clienteSalvo);
		Cliente novoClienteSalvo = clienteRepository.save(clienteSalvo);
		return novoClienteSalvo;
	}

	private void copyCliente(Cliente cliente, Cliente clienteSalvo) {
		if (cliente.getCpf() != null) {
			clienteSalvo.setCpf(cliente.getCpf());
		}
		if (cliente.getNome() != null) {
			clienteSalvo.setNome(cliente.getNome());
		}
		if (cliente.getEmail() != null) {
			clienteSalvo.setEmail(cliente.getEmail());
		}
		if (!cliente.getTelefones().isEmpty()) {
			for(String tel : cliente.getTelefones()) {
				clienteSalvo.getTelefones().add(tel);
			}
		}
		

	}

}
