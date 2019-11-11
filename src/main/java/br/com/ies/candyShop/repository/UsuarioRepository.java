package br.com.ies.candyShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ies.candyShop.entity.Usuario;

public interface UsuarioRepository<ENTITY extends Usuario> extends JpaRepository<ENTITY, Long>{
	
	@Query("select u from #{#entityName} as u where u.emailUsuario = :pEmailUsuario and u.senhaUsuario = :pSenhaUsuario")
	ENTITY findByEmailAndSenha(
			@Param("pEmailUsuario") String email,
			@Param("pSenhaUsuario") String senha);
	
}
