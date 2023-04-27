package br.com.etec.gabriel.cursoapipw.repository;

import br.com.etec.gabriel.cursoapipw.model.Curso;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends JpaRepository<Curso,Integer> {
}
