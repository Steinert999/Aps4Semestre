package br.com.ies.candyShop;

import br.com.ies.candyShop.entity.Role;
import br.com.ies.candyShop.repository.RoleRepository;
import br.com.ies.candyShop.utils.enums.RoleName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.EnumSet;

@SpringBootTest
class CandyShopAps4SemestreApplicationTests {

	@Autowired
	RoleRepository roleRepository;

	@Test
	void contextLoads() {

		EnumSet.allOf(RoleName.class).forEach(roleName -> {
			Role role = new Role();
			role.setName(roleName);
			roleRepository.save(role);
		});

	}
	
}
