package br.com.etec.gabriel.cursoapipw.repository.aluno;

import br.com.etec.gabriel.cursoapipw.model.Aluno;
import br.com.etec.gabriel.cursoapipw.model.Cidade;
import br.com.etec.gabriel.cursoapipw.repository.filter.AlunoFilter;
import br.com.etec.gabriel.cursoapipw.repository.filter.CidadeFilter;
import br.com.etec.gabriel.cursoapipw.repository.projections.AlunoDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

public class AlunoRepositoryImpl implements  AlunoRepositoryQuery {

  @Autowired
  private EntityManager manager;

  @Override
  public Page<AlunoDto> filtrar(AlunoFilter alunoFilter, Pageable pageable) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<AlunoDto> criteria = builder.createQuery(AlunoDto.class);
    Root<AlunoDto> root = criteria.from(AlunoDto.class);

    criteria.select(builder.construct(AlunoDto.class,
      root.get("id")
      ,
      root.get("nomealuno")
      ,
      root.get("cidade").get("nomecidade")
      ,
      root.get("cidade").get("uf")
      ,
      root.get("curso").get("nomecurso")


      ));

    Predicate[] predicates = criarRestricoes(builder, alunoFilter, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nomealuno")));

    TypedQuery<AlunoDto> query = manager.createQuery(criteria);
    adicionarRestricoesDaPaginacao(query, pageable);

    return new PageImpl<>(query.getResultList(),pageable, total(alunoFilter));
  }
  private void adicionarRestricoesDaPaginacao(TypedQuery<?> query, Pageable pageable)
  {
    int paginaatual = pageable.getPageNumber();
    int totalRegistroPorPagina = pageable.getPageSize();
    int primeiroRegistroDaPagina = paginaatual * totalRegistroPorPagina;

    query.setFirstResult(primeiroRegistroDaPagina);
    query.setMaxResults(totalRegistroPorPagina);
  }
  private Long total(AlunoFilter alunoFilter)
  {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<Long> criteria = builder.createQuery(Long.class);
    Root<Aluno> root = criteria.from(Aluno.class);

    Predicate[] predicates = criarRestricoes(builder, alunoFilter, root);
    criteria.where(predicates);
    criteria.orderBy(builder.asc(root.get("nomealuno")));
    criteria.select(builder.count(root));
    return manager.createQuery(criteria).getSingleResult();
  }
}
