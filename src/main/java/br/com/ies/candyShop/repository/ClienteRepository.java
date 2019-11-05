package br.com.ies.candyShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ies.candyShop.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {

}
