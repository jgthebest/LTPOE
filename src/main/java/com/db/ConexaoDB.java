package com.db;

import java.sql.Connection;

import java.sql.DriverManager;

import java.sql.SQLException;

public class ConexaoDB {

    public static Connection conectar() throws SQLException {

        String url = "jdbc:mysql://localhost:3307/ltpo";

        String usuario = "root";

        String senha = "";

        try {

            Class.forName("com.mysql.cj.jdbc.Driver");

            return DriverManager.getConnection(url, usuario, senha);

        } catch (ClassNotFoundException e) {

            e.printStackTrace();

            throw new SQLException("Driver MySQL não encontrado.");
        }
    }
}