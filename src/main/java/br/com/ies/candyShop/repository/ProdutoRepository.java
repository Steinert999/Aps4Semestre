package br.com.ies.candyShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.ies.candyShop.entity.Produto;

public interface ProdutoRepository extends JpaRepository<Produto, Integer>{

}
