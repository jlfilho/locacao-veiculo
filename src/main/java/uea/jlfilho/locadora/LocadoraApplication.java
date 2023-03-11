package uea.jlfilho.locadora;

import java.time.Instant;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import uea.jlfilho.locadora.entities.Carro;
import uea.jlfilho.locadora.entities.Categoria;
import uea.jlfilho.locadora.entities.Cliente;
import uea.jlfilho.locadora.entities.Locacao;
import uea.jlfilho.locadora.entities.enums.Cor;
import uea.jlfilho.locadora.repositories.CarroRepository;
import uea.jlfilho.locadora.repositories.CategoriaRepository;
import uea.jlfilho.locadora.repositories.ClienteRepository;
import uea.jlfilho.locadora.repositories.LocacaoRepository;

@SpringBootApplication
public class LocadoraApplication implements CommandLineRunner {
	
	@Autowired
	private CategoriaRepository categoriaRepository;
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	@Autowired
	private LocacaoRepository locacaoRepository;
	
	@Autowired
	private CarroRepository carroRepository;
	
	DateTimeFormatter fdt2 = DateTimeFormatter.ofPattern(
			"dd-MM-yyyy HH:mm");
	
	DateTimeFormatter fdt = DateTimeFormatter.ofPattern("dd-MM-yyyy");

	public static void main(String[] args) {
		SpringApplication.run(LocadoraApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {
		CadastrarCategoria();
		CadastrarCliente();
		CadastrarCarro();
		FazerLocacao();
		
	
	}

	private void FazerLocacao() {
		Locacao lo1 = new Locacao(null,
				Instant.now(),
				null,
				new Carro(1),
				new Cliente(1)
				);
		
		locacaoRepository.save(lo1);
	}

	private void CadastrarCarro() {
		Carro ca1 = new Carro(null, 
				"Fox 1.6 Mi Total Flex 8V 5p", 
				"MOE-9393", Cor.BRANCA, 2010, 
				LocalDate.parse("10-08-2010", fdt), 
				new Categoria(1));
		Carro ca2 = new Carro(null, 
				"Buggy IV e V", 
				"28159487714", Cor.PRETA, 1985, 
				LocalDate.parse("21-02-1985", fdt), 
				new Categoria(2));
		
		carroRepository.save(ca1);
		carroRepository.save(ca2);
		
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
