package br.com.ies.candyShop.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.ies.candyShop.entity.Usuario;
import br.com.ies.candyShop.repository.UsuarioRepository;

@Service
public class UsuarioService<ENTITY extends Usuario> {
	
	@Autowired
	UsuarioRepository<ENTITY> usuarioRepository;
	
	public ENTITY findByID(Long id) {
		return usuarioRepository.findById(id).get();
	}
	
	public List<ENTITY> findAll(){
		return usuarioRepository.findAll();
	}
	
	public void save (ENTITY usuario) {
		usuarioRepository.save(usuario);
	}
	
	public ENTITY findByEmailAndSenha (String email, String senha) {
		return usuarioRepository.findByEmailAndSenha(email, senha);
	}
	
	public Long countUsuarios() {
		return usuarioRepository.count();
	}
}
