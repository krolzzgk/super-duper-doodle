package com.apiwhiletrue.dao;

import com.apiwhiletrue.dao.util.ConnectionUtils;
import com.apiwhiletrue.model.Categoria;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author while true
 */
public class CategoriaDao {

    Connection conexao = null;

    public void inserir(Categoria categoria) throws Exception {
        String query = "insert into categoria (nome) values (?)";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setString(1, categoria.getNome());
            statement.execute();

        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

    public void atualizar(Categoria categoria) throws Exception {
        String query = "update categoria set nome = ? where id = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setString(1, categoria.getNome());
            statement.setInt(2, categoria.getId());
            statement.execute();

        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

    public void excluir(int id) throws Exception {
        String query = "delete from categoria where id = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, id);
            statement.execute();
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }
    }

    public ArrayList<Categoria> listar() throws Exception {
        ArrayList<Categoria> categorias = new ArrayList<>();

        String query = "select id, nome from categoria";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                categorias.add(new Categoria(result.getInt("id"), result.getString("nome")));
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }

        return categorias;
    }

    public Categoria getById(int id) throws Exception {
        Categoria categoria = null;

        String query = "select id, nome from categoria where id = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                categoria = new Categoria(result.getInt("id"), result.getString("nome"));
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }

        return categoria;
    }
}
