package com.example.demo;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.demo.domain.Cafe;
import com.example.demo.domain.Funcionario;
import com.example.demo.domain.ItemPedidoFuncionario;
import com.example.demo.domain.PedidoFuncionario;
import com.example.demo.repositories.CafeRepository;
import com.example.demo.repositories.FuncionarioRepository;
import com.example.demo.repositories.ItemPedidoFuncionarioRepository;
import com.example.demo.repositories.PedidoFuncionarioRepository;

@SpringBootApplication
public class DemoApplication implements CommandLineRunner {
	
	
	@Autowired
	private CafeRepository cafeRepository;
	@Autowired
	private FuncionarioRepository funcionarioRepository;
	@Autowired
	private PedidoFuncionarioRepository pedidoFuncionarioRepository;
	@Autowired
	private ItemPedidoFuncionarioRepository itemPedidoFuncionarioRepository;
	

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		/*
		Categoria cat1 = new Categoria(null,"Espresso");
		Categoria cat2 = new Categoria(null, "Intenso");
		Categoria cat3 = new Categoria(null, "Variations");
		
		Cafe caf1 = new Cafe(null, "Le Express", 1.50, 4, "Frutado");
		Cafe caf2 = new Cafe(null, "Pure Sense", 2.00, 7, "Intenso");
		Cafe caf3 = new Cafe(null, "Caramelito", 2.00, 6, "Frutado");
		Cafe caf4 = new Cafe(null, "Espresso 2222", 1.50, 4, "Equilibrado");
		
		
		cat1.getCafes().addAll(Arrays.asList(caf1, caf4));
		cat2.getCafes().addAll(Arrays.asList(caf2));
		cat3.getCafes().addAll(Arrays.asList(caf3));
		
		caf1.setCategoria(cat1);
		caf2.setCategoria(cat2);
		caf3.setCategoria(cat3);
		caf4.setCategoria(cat1);
		
		categoriaRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		cafeRepository.saveAll(Arrays.asList(caf1, caf2, caf3, caf4));
		*/
		
		//id, nome [miniDescricao, [descricao], preco, intensidade, perfilAromatico, variedade, imagem
		Cafe caf1 = new Cafe (null, "Roma", "ENCORPADO E BALANCEADO", "O equilíbrio dos Arábicas levemente torrados das Américas Central e do Sul com o Robusta proporciona ao Roma notas doces e amadeiradas e um sabor rico e persistente na boca.",  1.90, 8, "Intenso", "Intenso", "https://www.nespresso.com/ecom/medias/sys_master/public/9148239937566.png");
		Cafe caf2 = new Cafe (null, "Vivalto Lungo Decaffeinato", "EQUILIBRADO COM NOTAS FLORAIS", "Este Grand Cru tem o mesmo caráter equilibrado do Vivalto Lungo original, com notas de torrado, levemente amadeiradas, notas doces de cereais e uma sutil nota floral resultantes de um blend complexo de grãos Arábicas da América do Sul e da Etiópia. O perfil aromático desse café descafeinado é cuidadosamente preservado pelo processo de descafeinização natural, que respeita as características dos grãos de café, pois não utiliza solvente químicos, somente água, mantendo a intensidade e a riqueza de seus sabores.", 1.95, 4, "Frutado", "Decaffeinato", "https://www.nespresso.com/ecom/medias/sys_master/public/10252256870430.png");
		Cafe caf3 = new Cafe (null, "Caramelito", "AROMA NATURAL DE CARAMELO", "O aroma adocicado do caramelo suaviza as notas de torrado do café do Grand Cru Livanto. Este delicado casamento gastronômico evoca a cremosidade de uma bala toffee macia.",  2.40, 6, "Frutado", "Variations", "https://www.nespresso.com/ecom/medias/sys_master/public/9148305211422.png");
		Cafe caf4 = new Cafe (null, "Bukeela ka Ethiopia", "FLORAL E SILVESTRE", "Esse delicado Lungo possui um blend composto por Arábicas puros que vêm do berço do café, a Etiópia. O café de cada região é torrado separadamente: uma porção pequena com torra mais escura garante o corpo, a outra mais clara preserva as notas delicadas.", 2.20, 3, "Frutado", "Pure Origin", "https://www.nespresso.com/ecom/medias/sys_master/public/9249889681438.png");
		
		Funcionario func1 = new Funcionario (null, "Carlos", "TI");
		Funcionario func2 = new Funcionario (null, "Maria", "RH");
		
		PedidoFuncionario ped1 = new PedidoFuncionario (null, func1);
		PedidoFuncionario ped2 = new PedidoFuncionario (null, func2);
		PedidoFuncionario ped3 = new PedidoFuncionario (null, func1);
		
		ItemPedidoFuncionario item1 = new ItemPedidoFuncionario(null, func1, ped1, caf1, 3);
		ItemPedidoFuncionario item2 = new ItemPedidoFuncionario(null, func1, ped1, caf2, 5);
		ItemPedidoFuncionario item3 = new ItemPedidoFuncionario(null, func2, ped2, caf1, 1);
		ItemPedidoFuncionario item4 = new ItemPedidoFuncionario(null, func2, ped3, caf1, 7);
		ItemPedidoFuncionario item5 = new ItemPedidoFuncionario(null, func1, ped1, caf3, 1);
		ItemPedidoFuncionario item6 = new ItemPedidoFuncionario(null, func1, ped1, caf4, 4);

		//caf1.getItens().addAll(Arrays.asList(item1))

		func1.getPedidosfuncionario().addAll(Arrays.asList(ped1, ped2));
		ped1.getItenspedidofuncionario().addAll(Arrays.asList(item1, item2, item5, item6));
		
		cafeRepository.saveAll(Arrays.asList(caf1, caf2, caf3, caf4));
		funcionarioRepository.saveAll(Arrays.asList(func1, func2));
		pedidoFuncionarioRepository.saveAll(Arrays.asList(ped1, ped2, ped3));
		itemPedidoFuncionarioRepository.saveAll(Arrays.asList(item1, item2, item3, item4, item5, item6));
		
		System.out.println(caf1.getImagem());
		
		
		
	}
}
