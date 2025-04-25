package model;
import jakarta.persistence.*;

@Entity
public class Funcionario {
    @Id @GeneratedValue
    private Long func_id;
    private String nome;
    private String email;

    @ManyToOne
    @JoinColumn(name = "id_departamento")
    private Cargo cargo;

    public Funcionario(Long func_id, String nome, String email, Cargo cargo){
        this.func_id = func_id;
        this.nome = nome;
        this.email = email;
        this.cargo = cargo;
    }

    // getters
    public Long getFunc_id(){
        return func_id;
    }
    public String getNome(){
        return nome;
    }
    public String getEmail(){
        return email;
    }
    public Cargo getCargo(){
        return cargo;
    }
    // setters
    public void setFunc_id(Long func_id){
        this.func_id = func_id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setEmail(String email){
        this.email = email;
    }
    public void setCargo(Cargo cargo){
        this.cargo = cargo;
    }
}