package br.com.etec.gabriel.cursoapipw.repository.curso;

import br.com.etec.gabriel.cursoapipw.model.Curso;
import br.com.etec.gabriel.cursoapipw.repository.filter.CursoFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface CursoRepositoryQuery {

public Page<Curso> Filtrar(CursoFilter cursoFilter, Pageable pageable);

}
