package br.com.etec.gabriel.cursoapipw.repository;

import br.com.etec.gabriel.cursoapipw.model.Cidade;
import br.com.etec.gabriel.cursoapipw.repository.cidade.CidadeRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade,Integer>, CidadeRepositoryQuery{
}
