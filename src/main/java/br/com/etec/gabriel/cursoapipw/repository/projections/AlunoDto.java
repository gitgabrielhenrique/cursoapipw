package br.com.etec.gabriel.cursoapipw.repository.projections;

public class AlunoDto {
  private Long idalunos;
  private String nomealuno;
  private String nomecurso;
  private String nomecidade;
  private String uf;

  public AlunoDto(Long idalunos, String nomealuno, String nomecurso, String nomecidade, String uf) {
    this.idalunos = idalunos;
    this.nomealuno = nomealuno;
    this.nomecurso = nomecurso;
    this.nomecidade = nomecidade;
    this.uf = uf;
  }

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

  public String getNomecurso() {
    return nomecurso;
  }

  public void setNomecurso(String nomecurso) {
    this.nomecurso = nomecurso;
  }

  public String getNomecidade() {
    return nomecidade;
  }

  public void setNomecidade(String nomecidade) {
    this.nomecidade = nomecidade;
  }

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }
}
