package br.com.etec.gabriel.cursoapipw.repository;

import br.com.etec.gabriel.cursoapipw.model.Aluno;
import br.com.etec.gabriel.cursoapipw.repository.aluno.AlunoRepositoryQuery;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AlunoRepository extends JpaRepository<Aluno,Long>, AlunoRepositoryQuery {



}
