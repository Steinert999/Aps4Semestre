package br.com.ies.candyShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ies.candyShop.entity.Pedido;

public interface PedidoRepository extends JpaRepository<Pedido, Long>{

}
