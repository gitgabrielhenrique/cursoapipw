package br.com.etec.gabriel.cursoapipw.repository.cidade;
import br.com.etec.gabriel.cursoapipw.model.Cidade;
import br.com.etec.gabriel.cursoapipw.repository.filter.CidadeFilter;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
public interface CidadeRepositoryQuery {
  public Page<Cidade> filtrar(CidadeFilter cidadeFilter, Pageable pageable);
}
