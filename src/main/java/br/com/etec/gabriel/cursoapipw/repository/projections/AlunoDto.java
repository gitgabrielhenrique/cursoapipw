package br.com.etec.gabriel.cursoapipw.repository.projections;

public class AlunoDto {
  private Long idalunos;
  private String nomealuno;
  private String uf;
  private String nomecidade;
  private String nomecurso;

public AlunoDto(Long idalunos, String nomealuno, String uf, String nomecurso, String nomecidade){
this.idalunos=idalunos;
this.nomealuno=nomealuno;
this.nomecidade=nomecidade;
this.uf=uf;
this.nomecurso=nomecurso;

}

  public Long getId() {
    return idalunos;
  }

  public void setId(Long id) {
    this.idalunos = id;
  }

  public String getNomealuno() {
    return nomealuno;
  }

  public void setNomealuno(String nomealuno) {
    this.nomealuno = nomealuno;
  }

  public String getUf() {
    return uf;
  }

  public void setUf(String uf) {
    this.uf = uf;
  }

  public String getNomecidade() {
    return nomecidade;
  }

  public void setNomecidade(String nomecidade) {
    this.nomecidade = nomecidade;
  }

  public String getNomecurso() {
    return nomecurso;
  }

  public void setNomecurso(String nomecurso) {
    this.nomecurso = nomecurso;
  }
}
