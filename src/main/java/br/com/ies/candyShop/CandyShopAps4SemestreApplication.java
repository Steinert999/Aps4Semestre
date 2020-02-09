package br.com.ies.candyShop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.web.servlet.support.SpringBootServletInitializer;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableAutoConfiguration
@EntityScan(basePackages = "br.com.ies.candyShop.entity")
@ComponentScan({"br.com.ies.candyShop.*"})
@EnableJpaRepositories(basePackages = {"br.com.ies.candyShop.repository"})
public class CandyShopAps4SemestreApplication extends SpringBootServletInitializer{

	public static void main(final String[] args) {
        SpringApplication.run(CandyShopAps4SemestreApplication.class, args);

    }
}
