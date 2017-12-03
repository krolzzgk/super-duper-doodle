package com.apiwhiletrue.model;

/**
 *
 * @author while true
 */
public class Produto {
    private int id;
    private String nome;
    private double valor;
    private int categoriaId;
    private int fornecedorId;
    
    private Categoria categoria;
    private Fornecedor fornecedor;

    public Produto() {}
    
    public Produto(int id, String nome, double valor, int categoriaId, int fornecedorId) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.categoriaId = categoriaId;
        this.fornecedorId = fornecedorId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public int getCategoriaId() {
        return categoriaId;
    }

    public void setCategoriaId(int categoriaId) {
        this.categoriaId = categoriaId;
    }

    public int getFornecedorId() {
        return fornecedorId;
    }

    public void setFornecedorId(int fornecedorId) {
        this.fornecedorId = fornecedorId;
    }
    

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }
    
    
}
