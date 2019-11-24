package br.com.ies.candyShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.ies.candyShop.entity.Produto;


@Repository
@Transactional
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
