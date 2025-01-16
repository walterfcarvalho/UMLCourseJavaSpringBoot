package com.walterfcarvalho.cursoumc.cursoumc;

import java.text.SimpleDateFormat;
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
import com.walterfcarvalho.cursoumc.cursoumc.domain.ItemPedido;
import com.walterfcarvalho.cursoumc.cursoumc.domain.PagamentoBoleto;
import com.walterfcarvalho.cursoumc.cursoumc.domain.PagamentoCartao;
import com.walterfcarvalho.cursoumc.cursoumc.domain.Pedido;
import com.walterfcarvalho.cursoumc.cursoumc.domain.Produto;
import com.walterfcarvalho.cursoumc.cursoumc.domain.enums.EstadoPagamento;
import com.walterfcarvalho.cursoumc.cursoumc.domain.enums.TipoCliente;
import com.walterfcarvalho.cursoumc.cursoumc.repositories.CategoriaRepository;
import com.walterfcarvalho.cursoumc.cursoumc.repositories.CidadeRepository;
import com.walterfcarvalho.cursoumc.cursoumc.repositories.ClienteRepository;
import com.walterfcarvalho.cursoumc.cursoumc.repositories.EnderecoRepository;
import com.walterfcarvalho.cursoumc.cursoumc.repositories.EstadoRepository;
import com.walterfcarvalho.cursoumc.cursoumc.repositories.ItemPedidoRepository;
import com.walterfcarvalho.cursoumc.cursoumc.repositories.PagamentoRepository;
import com.walterfcarvalho.cursoumc.cursoumc.repositories.PedidoRepository;
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

	@Autowired
	private PedidoRepository pedidoRepository;

	@Autowired
	private PagamentoRepository pagamentoRepository;

	@Autowired
	private ItemPedidoRepository itemPedidoRepository;


	public static void main(String[] args) {

		SpringApplication.run(CursoumcApplication.class, args);

	}

	@Override
	public void run(String... args) throws Exception {


		Produto p1 = new Produto(null, "Computador", 1999);
		Produto p2 = new Produto(null, "Impressora", 799);
		Produto p3 = new Produto(null, "Mouse", 99);

		Categoria c1 = new Categoria(null, "informatica");
		Categoria c2 = new Categoria(null, "escritório");
		if (produtoRepository.count() < 1 && categoriaRepository.count() < 1) {

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


		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy hh:mm:ss");
		String dh = "13/01/2025 13:15:00";
		Pedido ped1 = new Pedido(null,  sdf.parse(dh), cliente1, endereco1);
		Pedido ped2 = new Pedido(null,  sdf.parse(dh), cliente2, endereco1);

		PagamentoCartao pagto1 = new PagamentoCartao(null, EstadoPagamento.QUITADO, ped1, 6);
		PagamentoBoleto pagto2 = new PagamentoBoleto(null, EstadoPagamento.PENDENTE, ped2, sdf.parse("10/12/2025 00:00:00s"), null);

		cliente1.getPedidos().addAll(Arrays.asList(ped1, ped2));

		ped1.setPagamento(pagto1);
		ped2.setPagamento(pagto2);

		ItemPedido ip1 = new ItemPedido(ped1, p1, 0.00, 1, 1.00);
		ItemPedido ip2 = new ItemPedido(ped2, p2, 0.00, 2, 1.00);
		ItemPedido ip3 = new ItemPedido(ped2, p3, 0.00, 2, 1.00);

		ped1.getItens().addAll(Arrays.asList(ip1, ip2));
		ped2.getItens().addAll(Arrays.asList(ip3));

		p1.getItensPedidos().addAll(Arrays.asList(ip1));
		p2.getItensPedidos().addAll(Arrays.asList(ip1));
		
		p3.getItensPedidos().addAll(Arrays.asList(ip2));


		if ( pedidoRepository.count() < 1) {

			pedidoRepository.saveAll( Arrays.asList(ped1, ped2) );

			itemPedidoRepository.saveAll( Arrays.asList(ip1, ip2,ip3));

			pagamentoRepository.saveAll(Arrays.asList(pagto1, pagto2));

		}


		System.out.println("=====================  ==> Run finished");
	}



}