package br.com.bruno.backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.bruno.backend.model.Produto;


@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Long>{

}
