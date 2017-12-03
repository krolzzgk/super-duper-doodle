package com.apiwhiletrue.dao;

import com.apiwhiletrue.dao.util.ConnectionUtils;
import com.apiwhiletrue.model.Fornecedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author while true
 */
public class FornecedorDao {

    Connection conexao = null;

    public void inserir(Fornecedor fornecedor) throws Exception {
        String query = "insert into fornecedor (nome) values (?)";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setString(1, fornecedor.getNome());
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

    public void atualizar(Fornecedor fornecedor) throws Exception {
        String query = "update fornecedor set nome = ? where id = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setString(1, fornecedor.getNome());
            statement.setInt(2, fornecedor.getId());
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
        String query = "delete from fornecedor where id = ?";
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

    public ArrayList<Fornecedor> listar() throws Exception {
        ArrayList<Fornecedor> fornecedores = new ArrayList<>();

        String query = "select id, nome from fornecedor";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                fornecedores.add(new Fornecedor(result.getInt("id"), result.getString("nome")));
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }

        return fornecedores;
    }

    public Fornecedor getById(int id) throws Exception {
        Fornecedor categoria = null;

        String query = "select id, nome from fornecedor where id = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                categoria = new Fornecedor(result.getInt("id"), result.getString("nome"));
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
