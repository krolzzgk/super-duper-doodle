
package com.apiwhiletrue.dao;

import com.apiwhiletrue.dao.util.ConnectionUtils;
import com.apiwhiletrue.model.Categoria;
import com.apiwhiletrue.model.Fornecedor;
import com.apiwhiletrue.model.Produto;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

/**
 *
 * @author while true
 */
public class ProdutoDao {

    Connection conexao = null;

    public void inserir(Produto produto) throws Exception {
        String query = "insert into produto (nome, valor, categoriaId, fornecedorId) "
                + "values (?, ?, ?, ?)";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setString(1, produto.getNome());
            statement.setDouble(2, produto.getValor());
            statement.setInt(3, produto.getCategoriaId());
            statement.setInt(4, produto.getFornecedorId());
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

    public void atualizar(Produto produto) throws Exception {
        String query = "update produto "
                + "set nome = ?, "
                + "valor = ? "
                + "where id = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setString(1, produto.getNome());
            statement.setDouble(2, produto.getValor());
            statement.setInt(3, produto.getId());
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
        String query = "delete from produto where id = ?";
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
    
    public ArrayList<Produto> listar() throws Exception {
        ArrayList<Produto> produtos = new ArrayList<>();

        String query = "select * from select_produto";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                Produto p = new Produto(
                        result.getInt("produto_id"), 
                        result.getString("produto_nome"), 
                        result.getDouble("produto_valor"), 
                        result.getInt("categoria_id"), 
                        result.getInt("fornecedor_id"));
                p.setCategoria(new Categoria(result.getInt("categoria_id"), result.getString("categoria_nome")));
                p.setFornecedor(new Fornecedor(result.getInt("fornecedor_id"), result.getString("fornecedor_nome")));
                
                produtos.add(p);
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }

        return produtos;
    }
    
    public Produto getById(int id) throws Exception {
        Produto produto = null;

        String query = "select * from select_produto where produto_id = ?";
        PreparedStatement statement = null;

        try {
            conexao = ConnectionUtils.getConnection();
            statement = conexao.prepareStatement(query);
            statement.setInt(1, id);
            ResultSet result = statement.executeQuery();

            while (result.next()) {
                produto = new Produto(
                        result.getInt("produto_id"), 
                        result.getString("produto_nome"), 
                        result.getDouble("produto_valor"), 
                        result.getInt("categoria_id"), 
                        result.getInt("fornecedor_id"));
                produto.setCategoria(new Categoria(result.getInt("categoria_id"), result.getString("categoria_nome")));
                produto.setFornecedor(new Fornecedor(result.getInt("fornecedor_id"), result.getString("fornecedor_nome")));
            }
        } finally {
            if (statement != null && !statement.isClosed()) {
                statement.close();
            }

            if (conexao != null || !conexao.isClosed()) {
                conexao.close();
            }
        }

        return produto;
    }
}
