package br.com.etec.gabriel.cursoapipw.repository.aluno;

import br.com.etec.gabriel.cursoapipw.model.Aluno;
import br.com.etec.gabriel.cursoapipw.model.Cidade;
import br.com.etec.gabriel.cursoapipw.repository.filter.AlunoFilter;
import br.com.etec.gabriel.cursoapipw.repository.filter.CidadeFilter;
import br.com.etec.gabriel.cursoapipw.repository.projections.AlunoDto;
import org.apache.commons.lang3.StringUtils;
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
import java.util.ArrayList;
import java.util.List;

public class AlunoRepositoryImpl implements  AlunoRepositoryQuery {

  @Autowired
  private EntityManager manager;

  @Override
  public Page<AlunoDto> filtrar(AlunoFilter alunoFilter, Pageable pageable) {
    CriteriaBuilder builder = manager.getCriteriaBuilder();
    CriteriaQuery<AlunoDto> criteria = builder.createQuery(AlunoDto.class);
    Root<Aluno> root = criteria.from(Aluno.class);

    criteria.select(builder.construct(AlunoDto.class,
      root.get("idalunos")
      ,root.get("nomealuno")
      ,root.get("curso").get("nomecurso")
      ,root.get("cidade").get("nomecidade")
      ,root.get("cidade").get("uf")
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

  private Predicate[] criarRestricoes(CriteriaBuilder builder, AlunoFilter alunoFilter, Root<Aluno> root) {
    List<Predicate> predicates = new ArrayList<>();

    if (!StringUtils.isEmpty(alunoFilter.getNomealuno()))
    {
      predicates.add(builder.like(builder.lower(root.get("nomealuno ")),
        "%" + alunoFilter.getNomealuno().toLowerCase() + "%"
      ));
    }

    if (!StringUtils.isEmpty(alunoFilter.getNomecidade()))
    {
      predicates.add(builder.like(builder.lower(root.get("cidade").get("nomecidade")),
        "%" + alunoFilter.getNomecidade().toLowerCase() + "%"
      ));
    }

    if (!StringUtils.isEmpty(alunoFilter.getUf() ))
    {
      predicates.add(builder.equal(builder.lower(root.get("cidade").get("uf")),
         alunoFilter.getUf().toLowerCase()
      ));

      if (!StringUtils.isEmpty(alunoFilter.getNomecurso()))
      {
        predicates.add(builder.like(builder.lower(root.get("curso").get("nomecurso")),
          "%" + alunoFilter.getNomecurso().toLowerCase() + "%"
        ));
      }
    }

    return predicates.toArray(new Predicate[predicates.size()]);

  }
}
