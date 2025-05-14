package com.ltpo;

import java.util.List;

import com.ltpo.DAO.UsuarioDAO;
import com.ltpo.DAO.ModeloDAO;
import com.ltpo.DAO.AutomovelDAO;
import com.ltpo.enums.Tipo;
import com.ltpo.model.Automovel;
import com.ltpo.model.Modelo;
import com.ltpo.model.Usuario;

public class Main {
    public static void main(String[] args){
        AutomovelDAO automovelDAO = new AutomovelDAO();
        ModeloDAO modeloDAO = new ModeloDAO();
        UsuarioDAO usuarioDAO = new UsuarioDAO();

// Inserir um novo usuário.
        Modelo modelo = new Modelo("Argo", "Fiat");
        Automovel automovel = new Automovel("Fiat Argo", 2023, "Vermelho");
        Usuario usuario = new Usuario(Tipo.CLIENTE, "João", "61 9 9544-5533");

        automovelDAO.salvar(automovel);
        modeloDAO.salvar(modelo);
        usuarioDAO.salvar(usuario);


        System.out.println("Automóvel inserido: " + automovel);
        System.out.println("Modelo inserido: " + modelo);
        System.out.println("Usuario inserido: " + usuario);

// Buscar todos os automóveis

        List<Automovel> automoveis = automovelDAO.buscarTodos();
        List<Modelo> modelos = modeloDAO.buscarTodos();
        List<Usuario> usuarios = usuarioDAO.buscarTodos();
        System.out.println("\nTodos os automóveis:");
        for (Automovel a : automoveis) {
            System.out.println(a);
// Buscar um usuário por ID
            Automovel automovelBuscado = automovelDAO.buscarPorId(1);
            System.out.println("\nAutomóvel com ID 1: " + automovelBuscado);
        }
        System.out.println("\nTodos os modelos: ");
        for (Modelo m : modelos){
            System.out.println(m);
            Modelo modeloBuscado = modeloDAO.buscarPorId(1);
            System.out.println("\nModelo com ID 1: " + modeloBuscado);
        }
        System.out.println("\nTodos os usuarios: ");
        for (Usuario u : usuarios){
            System.out.println(u);
            Usuario usuarioBuscado = usuarioDAO.buscarPorId(1);
            System.out.println("\nUsuário com ID 1: " + usuarioBuscado);
        }
    }
}

