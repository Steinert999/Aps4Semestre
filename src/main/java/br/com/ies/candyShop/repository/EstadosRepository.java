package br.com.ies.candyShop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.ies.candyShop.entity.Estados;

public interface EstadosRepository extends JpaRepository<Estados, Long>{
	
	@Query("select e from Estados e where e.cdEstado = :pCdEstado")
	Estados findByCdEstado(
			@Param("pCdEstado") String cdEstado);
}
