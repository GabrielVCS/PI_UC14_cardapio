/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cardapio.cardapioPi.model;

public class Produto {
   private Integer id;
    private String nome;
    private double preco; // cpf vai ser a senha spa
    private String ingredientes;
    private String calorias;
    private String carboidratos;
    private String proteinas;
    private String gorduras;
    private String categoria;
    
    public Produto() {
    
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public void setIngredientes(String ingredientes) {
        this.ingredientes = ingredientes;
    }

    public String getCalorias() {
        return calorias;
    }

    public void setCalorias(String calorias) {
        this.calorias = calorias;
    }

    public String getCarboidratos() {
        return carboidratos;
    }

    public void setCarboidratos(String carboidratos) {
        this.carboidratos = carboidratos;
    }

    public String getProteinas() {
        return proteinas;
    }

    public void setProteinas(String proteinas) {
        this.proteinas = proteinas;
    }

    public String getGorduras() {
        return gorduras;
    }

    public void setGorduras(String gorduras) {
        this.gorduras = gorduras;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    

    public Produto(Integer id, String nome, double preco, String ingredientes, String calorias,
            String carboidratos, String proteinas, String gorduras, String categoria) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.ingredientes = ingredientes;
        this.calorias = calorias;
        this.carboidratos = carboidratos;
        this.proteinas = proteinas;
        this.gorduras = gorduras;
        this.categoria = categoria;
        
    }
}
