package br.com.ies.candyShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EntityScan(basePackages = "br.com.ies.candyShop.entity")
@ComponentScan(basePackages = {"br.com.ies.*"})
public class CandyShopAps4SemestreApplication {

	public static void main(String[] args) {
		SpringApplication.run(CandyShopAps4SemestreApplication.class, args);
	}

}
