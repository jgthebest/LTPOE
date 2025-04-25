package model;
import jakarta.persistence.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Entity
public class Departamento {
    @Id @GeneratedValue
    private Long id_departamento;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "departamento", cascade = CascadeType.ALL)
    private List<Cargo> cargos = new ArrayList<>();

    public Departamento(Long id_departamento, String nome, String descricao, List<Cargo> cargos){
        this.id_departamento = id_departamento;
        this.nome = nome;
        this.descricao = descricao;
        this.cargos = new ArrayList<>(cargos);
    }

    public Long getIdDept(){
        return id_departamento;
    }
    public String getNome(){
        return nome;
    }
    public String getDescricao(){
        return descricao;
    }
    public List<Cargo> getCargos(){
        return cargos;
    }

    public void setIdDept(Long id_departamento){
        this.id_departamento = id_departamento;
    }

    public void setNome(String nome){
        this.nome = nome;
    }
    public void setDescricao(String descricao){
        this.descricao = descricao;
    }
    public void setCargos(List<Cargo> cargos){
        this.cargos = new ArrayList<>(cargos);
    }

}
