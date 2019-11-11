package br.com.ies.candyShop.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import br.com.ies.candyShop.entity.Usuario;
import br.com.ies.candyShop.enums.PerfilAcesso;
import br.com.ies.candyShop.services.UsuarioService;

@Controller
public class IndexController {
	
	@Autowired
	UsuarioService<? extends Usuario> usuarioService;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String viewLoginPage() {
		return "Index/Index";
	}
	
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String redirectPageByPerfilAcesso(PerfilAcesso perfilAcesso) {
		try {
			Usuario usuario = usuarioService.findByEmailAndSenha(
					perfilAcesso
						.getPerfilAcesso()
						.getEmailUsuario(),
						
					perfilAcesso
						.getPerfilAcesso()
						.getSenhaUsuario());
			
			if(usuario == PerfilAcesso.CLIENTE.getPerfilAcesso()) {
				System.out.println("Perfil Cliente logado com sucesso");
				return "redirect:/Index/Index";
			}else if(usuario == PerfilAcesso.FORNECEDOR.getPerfilAcesso()) {
				System.out.println("Perfil Fornecedor logado com sucesso");
				return "redirect:/Index/Index";
			}
			return null;
		}catch (Exception e) {
			e.getCause();
			return "Index/Index";
		}
		
	}
	
}
