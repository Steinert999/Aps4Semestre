package br.com.ies.candyShop;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import br.com.ies.candyShop.entity.Cliente;
import br.com.ies.candyShop.entity.Endereco;
import br.com.ies.candyShop.enums.FormatosDatas;
import br.com.ies.candyShop.repository.EnderecoRepository;
import br.com.ies.candyShop.repository.EstadosRepository;
import br.com.ies.candyShop.repository.UsuarioRepository;

@SpringBootTest
class CandyShopAps4SemestreApplicationTests {
	
	@Autowired
	EstadosRepository estadosRepository;
	@Autowired
	EnderecoRepository enderecoRepository;
	
	@Autowired
	UsuarioRepository<Cliente> clienteRepository;
	
	@Test
	void contextLoads() {
		
		Cliente eu = new Cliente();
		String data = "10/11/2019";
		
		eu.setDtVirouCliente(FormatosDatas.formatarStringToData(data, FormatosDatas.BRASIL));
		eu.setEmailUsuario("steinert999@outlook.com");
		Endereco meuEndereco = enderecoRepository.findById(Long.parseLong("1")).get();
		eu.setEndereco(meuEndereco);
		eu.setNmCliente("Guilherme Steinert de Azevedo");
		eu.setSenhaUsuario("123456");
		eu.setTelCliente("48991853782");
		
//		clienteRepository.save(eu);
	
		
		
		
//		Endereco endereco = new Endereco();
//		endereco.setEstado(estadosRepository.findByCdEstado(EnumEstado.SC.name()));
//		endereco.setNmBairro("Caminho Novo");
//		endereco.setNmRua("Manoel Carlos Daussem");
//		endereco.setNuLogradouro(83);
//		endereco.setNuCep("88132565");
//		
//		enderecoRepository.save(endereco);
		
		
//		for(EnumEstado estados : EnumSet.allOf(EnumEstado.class)) {
//			Estados estado = new Estados();
//			
//			System.out.println(estados.getEstado() + " | " + 
//			EnumEstado.getListSiglaEstados().get(estados.ordinal()));
//			
//			estado.setNmEstado(estados.getEstado());
//			estado.setCdEstado(EnumEstado.getListSiglaEstados().get(estados.ordinal()));
//			estadosRepository.save(estado);
//		}
		
	}
	
}
