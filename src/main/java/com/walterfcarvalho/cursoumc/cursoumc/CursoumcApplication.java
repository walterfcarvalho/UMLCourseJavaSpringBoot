package com.walterfcarvalho.cursoumc.cursoumc;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.walterfcarvalho.cursoumc.cursoumc.domain.Categoria;
import com.walterfcarvalho.cursoumc.cursoumc.domain.Cidade;
import com.walterfcarvalho.cursoumc.cursoumc.domain.Cliente;
import com.walterfcarvalho.cursoumc.cursoumc.domain.Endereco;
import com.walterfcarvalho.cursoumc.cursoumc.domain.Estado;
import com.walterfcarvalho.cursoumc.cursoumc.domain.Produto;
import com.walterfcarvalho.cursoumc.cursoumc.domain.enums.TipoCliente;
import com.walterfcarvalho.cursoumc.cursoumc.repositories.CategoriaRepository;
import com.walterfcarvalho.cursoumc.cursoumc.repositories.CidadeRepository;
import com.walterfcarvalho.cursoumc.cursoumc.repositories.ClienteRepository;
import com.walterfcarvalho.cursoumc.cursoumc.repositories.EnderecoRepository;
import com.walterfcarvalho.cursoumc.cursoumc.repositories.EstadoRepository;
import com.walterfcarvalho.cursoumc.cursoumc.repositories.ProdutoRepository;

@SpringBootApplication
public class CursoumcApplication implements CommandLineRunner {

	@Autowired
	private CategoriaRepository categoriaRepository;

	@Autowired
	private ProdutoRepository produtoRepository;

	@Autowired
	private EstadoRepository estadoRepository;

	@Autowired
	private CidadeRepository cidadeRepository;

	@Autowired
	private ClienteRepository clienteRepository;

	@Autowired
	private EnderecoRepository enderecoRepository;

	public static void main(String[] args) {

		SpringApplication.run(CursoumcApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {


		if (produtoRepository.count() < 1 && categoriaRepository.count() < 1) {
			Produto p1 = new Produto(null, "Computador", 1999);
			Produto p2 = new Produto(null, "Impressora", 799);
			Produto p3 = new Produto(null, "Mouse", 99);

			Categoria c1 = new Categoria(null, "informatica");
			Categoria c2 = new Categoria(null, "escritório");

			produtoRepository.saveAll(Arrays.asList(p1, p2, p3));

			categoriaRepository.saveAll(Arrays.asList(c1, c2));

			p1.getCategorias().addAll(Arrays.asList(c1));
			p2.getCategorias().addAll(Arrays.asList(c1, c2));
			p3.getCategorias().addAll(Arrays.asList(c1));

			c1.getProdutos().addAll(Arrays.asList(p1, p2, p3));
			c2.getProdutos().addAll(Arrays.asList(p2));

			produtoRepository.saveAll(Arrays.asList(p1, p2, p3));
			categoriaRepository.saveAll(Arrays.asList(c1, c2));
		}

		// estados
		Estado ce = new Estado(null, "Ceará");
		Estado sp = new Estado(null, "São Paulo");
		Cidade novaRussas = new Cidade(null, "Nova Russas", ce);
		Cidade saoPaulo = new Cidade(null, "Sao Paulo", sp);
		if (estadoRepository.count() < 1 && estadoRepository.count() < 1) {

			estadoRepository.saveAll(Arrays.asList(ce, sp));

			cidadeRepository.saveAll(Arrays.asList(novaRussas, saoPaulo));

			ce.getCidades().addAll(Arrays.asList(novaRussas));
			sp.getCidades().addAll(Arrays.asList(saoPaulo));
			estadoRepository.saveAll(Arrays.asList(ce, sp));
		}

		Cliente cliente1 = new Cliente(null, "Cliente001", "1@2.com", "82261318391", TipoCliente.FISICA);
		Cliente cliente2 = new Cliente(null, "Cliente002", "1@2.com", "67232094353", TipoCliente.FISICA);
		Endereco endereco1 = new Endereco(null, "rua", "001", "complemento", 
			"bairro", "0000000", novaRussas,cliente1);

		if (clienteRepository.count() < 1) {
			cliente1.getTelefones().addAll(Arrays.asList("11111", "22222"));

			clienteRepository.saveAll(Arrays.asList(cliente1, cliente2));

			enderecoRepository.saveAll(Arrays.asList(endereco1));

			cliente1.getEnderecos().addAll(Arrays.asList(endereco1));

		}
		System.out.println("=====================  ==> Run finished");
	}
}