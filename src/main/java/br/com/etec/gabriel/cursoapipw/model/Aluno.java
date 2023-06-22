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


    public Long getId() {
        return idalunos;
    }

    public void setId(Long id) {
        this.idalunos = id;
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

    public String getNomealuno() {
        return nomealuno;
    }

    public void setNomealuno(String nomealuno) {
        this.nomealuno = nomealuno;
    }






    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluno aluno = (Aluno) o;
        return idalunos == aluno.idalunos;
    }

    @Override
    public int hashCode() {
        return Objects.hash(idalunos);
    }
}
