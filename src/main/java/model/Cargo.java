package model;
import jakarta.persistence.*;
import org.hibernate.annotations.Cascade;

import java.util.ArrayList;
import java.util.List;

@Entity
public class Cargo {
    @Id @GeneratedValue
    private Long id_cargo;
    private String nome;
    private String descricao;

    @OneToMany(mappedBy = "cargo", cascade = CascadeType.ALL)
    private List<Funcionario> funcionarios = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Departamento departamento;


    public Cargo(Long id_cargo, String nome, String descricao, Departamento departamento, List<Funcionario> funcionarios){
        this.id_cargo = id_cargo;
        this.nome = nome;
        this.descricao = descricao;
        this.departamento = departamento;
        this.funcionarios = new ArrayList<>(funcionarios);
    }

    // getters
    public Long getId_cargo(){
        return id_cargo;
    }
    public String getNome(){
        return nome;
    }
    public String getDescricao(){
        return descricao;
    }
    public Departamento getDepartamento(){
        return departamento;
    }
    public List<Funcionario> getFuncionarios(){
        return funcionarios;
    }

    // setters
    public void setId_cargo(Long id_cargo){
        this.id_cargo = id_cargo;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public void setDepartamento(Departamento departamento){
        this.departamento = departamento;
    }
    public void setFuncionarios(List<Funcionario> funcionarios){
        this.funcionarios = new ArrayList<>(funcionarios);
    }
}
