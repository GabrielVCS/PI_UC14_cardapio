/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cardapio.cardapioPi.controller;

import com.cardapio.cardapioPi.data.ClienteEntity;
import com.cardapio.cardapioPi.data.ProdutoEntity;
import com.cardapio.cardapioPi.service.ClienteService;
import com.cardapio.cardapioPi.service.ProdutoService;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;

import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.DeleteMapping;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.PostMapping;

import org.springframework.web.bind.annotation.PutMapping;

import org.springframework.web.bind.annotation.RequestBody;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

@RestController

@RequestMapping("/telaInicial")

public class ProdutoControllerApi {

    @Autowired

    ProdutoService produtoService;

    @GetMapping("/listarProd")

    public ResponseEntity<List> getAllProdutos() {

        List<ProdutoEntity> produtos = produtoService.listarTodosProdutos();

        return new ResponseEntity<>(produtos, HttpStatus.OK);

    }

    @GetMapping("/pesquisarProd/{id}")

    public ResponseEntity<ProdutoEntity> getProdutoById(@PathVariable Integer id) {

        ProdutoEntity produto = produtoService.getProdutoId(id);

        return new ResponseEntity<>(produto, HttpStatus.OK);

    }

    @PostMapping("/adicionarProd")

    public ResponseEntity<ProdutoEntity> addProduto(@RequestBody ProdutoEntity prod) {

        var novoProduto = produtoService.criarProduto(prod);

        return new ResponseEntity<>(novoProduto, HttpStatus.CREATED);

    }

    @PutMapping("/atualizarProd/{id}")

    public ResponseEntity<ProdutoEntity> atualizarProduto(@PathVariable Integer id, @RequestBody ProdutoEntity produto) {

        var produtoAtualizado = produtoService.atualizarProduto(id, produto);

        return new ResponseEntity<>(produtoAtualizado, HttpStatus.OK);

    }

    @DeleteMapping("/deletarProd/{id}")

    public ResponseEntity deletarProduto(@PathVariable Integer id) {

        produtoService.deletarProduto(id);

        return new ResponseEntity<>(HttpStatus.OK);

    }

}
