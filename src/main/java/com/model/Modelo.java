package com.model;

import jakarta.persistence.*;

@Entity
@Table(name = "modelo")
public class Modelo {
    @Id @GeneratedValue @Column(name = "id")
    private int id;
    private String nome;
    private String marca;

    @OneToOne(mappedBy = "modelo")
    private Automovel automovel;

    public Modelo(int id, String nome, String marca){
        this.id = id;
        this.nome = nome;
        this.marca = marca;
    }

    public int getId(){return id;}
    public String getNome(){return nome;}
    public String marca(){return marca;}
    public com.model.Automovel getAutomovel(){return automovel;}

    public void setId(int id){
        this.id = id;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }
    public void setAutomovel(com.model.Automovel automovel){
        this.automovel = automovel;
    }

}
