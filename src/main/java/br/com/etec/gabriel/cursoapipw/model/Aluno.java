package br.com.etec.gabriel.cursoapipw.model;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="aluno")
public class Aluno {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idalunos;

    private String nomealuno;

    @ManyToOne
    @JoinColumn(name="idcurso")
       private Curso curso;

    @ManyToOne
    @JoinColumn(name="idcidade")
    private Cidade cidade;

  public Long getIdalunos() {
    return idalunos;
  }

  public void setIdalunos(Long idalunos) {
    this.idalunos = idalunos;
  }

  public String getNomealuno() {
    return nomealuno;
  }

  public void setNomealuno(String nomealuno) {
    this.nomealuno = nomealuno;
  }

  public Curso getCurso() {
    return curso;
  }

  public void setCurso(Curso curso) {
    this.curso = curso;
  }

  public Cidade getCidade() {
    return cidade;
  }

  public void setCidade(Cidade cidade) {
    this.cidade = cidade;
  }


  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Aluno aluno = (Aluno) o;
    return idalunos.equals(aluno.idalunos);
  }

  @Override
  public int hashCode() {
    return Objects.hash(idalunos);
  }
}
