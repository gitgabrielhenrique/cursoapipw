package br.com.etec.gabriel.cursoapipw.model;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="cidade")
public class Cidade {


@Id
@GeneratedValue(strategy =  GenerationType.IDENTITY)
    private Integer id;

    private String uf;

    private String nomecidade;
@JsonIgnore
    @OneToMany(mappedBy = "cidade")
private List<Aluno> alunocidade= new ArrayList<>();


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNomeCidade() {
        return nomecidade;
    }

    public void setNomeCidade(String nomeCidade) {
        this.nomecidade = nomeCidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public List<Aluno> getAlunocidade() {
        return alunocidade;
    }

    public void setAlunocidade(List<Aluno> alunocidade) {
        this.alunocidade = alunocidade;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cidade cidade = (Cidade) o;
        return id.equals(cidade.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
