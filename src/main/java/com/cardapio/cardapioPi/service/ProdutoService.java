/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cardapio.cardapioPi.service;

import com.cardapio.cardapioPi.data.ClienteEntity;
import com.cardapio.cardapioPi.data.ClienteRepository;
import com.cardapio.cardapioPi.data.ProdutoEntity;
import com.cardapio.cardapioPi.data.ProdutoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ProdutoService {

    @Autowired

    ProdutoRepository produtoRepository;

    public ProdutoEntity criarProduto(ProdutoEntity prod) {

        prod.setId(null);

        produtoRepository.save(prod);

        return prod;

    }

    public ProdutoEntity atualizarProduto(Integer prodId, ProdutoEntity produtoRequest) {

        ProdutoEntity prod = getProdutoId(prodId);

        prod.setNome(produtoRequest.getNome());

        prod.setPreco(produtoRequest.getPreco());

        prod.setIngredientes(produtoRequest.getIngredientes());

        prod.setCalorias(produtoRequest.getCalorias());

        prod.setCarboidratos(produtoRequest.getCarboidratos());

        prod.setProteinas(produtoRequest.getProteinas());

        prod.setGorduras(produtoRequest.getGorduras());

        prod.setCategoria(produtoRequest.getCategoria());

        produtoRepository.save(prod);

        return prod;

    }

    public ProdutoEntity getProdutoId(Integer prodId) {

        return produtoRepository.findById(prodId).orElse(null);

    }

    public List<ProdutoEntity> listarTodosProdutos() {

        return produtoRepository.findAll();

    }

    public void deletarProduto(Integer prodId) {

        ProdutoEntity prod = getProdutoId(prodId);

        produtoRepository.deleteById(prod.getId());

    }

}
