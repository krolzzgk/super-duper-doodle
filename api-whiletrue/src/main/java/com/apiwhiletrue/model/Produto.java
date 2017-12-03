package com.apiwhiletrue.model;

/**
 *
 * @author while true
 */
public class Produto {
    private int id;
    private String nome;
    private double valor;
    private Categoria categoria;

    public Produto() {}
    
    public Produto(int id, String nome, double valor, Categoria categoria) {
        this.id = id;
        this.nome = nome;
        this.valor = valor;
        this.categoria = categoria;
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

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }
    
    
}
