package uea.jlfilho.locadora;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uea.jlfilho.locadora.entities.Categoria;
import uea.jlfilho.locadora.entities.Cliente;
import uea.jlfilho.locadora.repositories.CategoriaRepository;
import uea.jlfilho.locadora.repositories.ClienteRepository;

@SpringBootApplication
public class LocadoraApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;

	public static void main(String[] args) {
		SpringApplication.run(LocadoraApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		CadastrarCategoria();
		CadastrarCliente();
	
	}

	private void CadastrarCliente() {
		Cliente cl1 = new Cliente(null, "Pedro José", "601.978.470-30",
				"pedro@gmail.com");
		cl1.getTelefones().add("92-925566-4477");
		cl1.getTelefones().add("92-928899-4971");
		
		clienteRepository.save(cl1);
		
		Cliente cl2 = new Cliente(null, "Maria Aparecidad", "743.412.800-31",
				"maria@gmail.com");
		cl2.getTelefones().add("92-8544-9832");
		
		
		clienteRepository.save(cl2);
		
		
	}

	private void CadastrarCategoria() {
		Categoria cat1 = new Categoria(null,"Esportivo", 150.00);
		Categoria cat2 = new Categoria(null,"Básico", 110.00);
		Categoria cat3 = new Categoria(null,"Luxo", 200.00);
		categoriaRepository.saveAll(Arrays.asList(cat1,cat2,cat3));
	}

}
