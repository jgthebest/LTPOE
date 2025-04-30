package com;

import com.model.*;
import java.util.List;

import com.DAO.AutomovelDAO;

public class Main {
    public static void main(String[] args){
        AutomovelDAO automovelDAO = new AutomovelDAO();

// Inserir um novo usuário.
        Modelo modelo = new Modelo(1, "Argo", "Fiat");
        Automovel automovel = new Automovel();

        automovelDAO.salvar(automovel);

        System.out.println("Automóvel inserido:" + automovel);

// Buscar todos os automóveis

        List<Automovel> automoveis = automovelDAO.buscarTodos();

        System.out.println("\nTodos os automóveis:");

        for (Automovel a : automoveis) {

            System.out.println(a);

// Buscar um usuário por ID

            Automovel automovelBuscado = automovelDAO.buscarPorId(1);

            System.out.println("\nAutomóvel com ID 1: " + automovelBuscado);

// Fechar o EntityManager

    }
}
}
