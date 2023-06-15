package br.com.etec.gabriel.cursoapipw.repository.aluno;

import br.com.etec.gabriel.cursoapipw.repository.filter.AlunoFilter;
import br.com.etec.gabriel.cursoapipw.repository.projections.AlunoDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface AlunoRepositoryQuery {

  public Page<AlunoDto> filtrar(AlunoFilter alunoFilter, Pageable pageable);
}
