/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cardapio.cardapioPi.controller;

import com.cardapio.cardapioPi.data.ClienteEntity;
import com.cardapio.cardapioPi.data.ProdutoEntity;
import com.cardapio.cardapioPi.service.ClienteService;
import com.cardapio.cardapioPi.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller

public class ProdController {

    @Autowired
    ProdutoService produtoService;

    @GetMapping("/Prod")
    public String viewHomePage(Model model) {
        model.addAttribute("listarProdutos", produtoService.listarTodosProdutos());
        return "telaInicial";
    }

    @GetMapping("/deletarProduto/{id}")
    public String deletarProduto(@PathVariable(value = "id") Integer id) {
        produtoService.deletarProduto(id);
        return "redirect:/";
    }

    @GetMapping("/criarProdutoForm")
    public String criarProdutoForm(Model model) {
        ProdutoEntity prod = new ProdutoEntity();
        model.addAttribute("produto", prod);
        return "telaCadProduto";
    }

    @PostMapping("/salvarProduto")

    public String salvarProduto(@Valid @ModelAttribute("produto") ProdutoEntity prod, BindingResult result) {

        if (result.hasErrors()) {

            return "telaCadProduto";

        }

        if (prod.getId() == null) {

            produtoService.criarProduto(prod);

        } else {

            produtoService.atualizarProduto(prod.getId(), prod);

        }

        return "redirect:/";

    }

    @GetMapping("/atualizarProdutoForm/{id}")

    public String atualizarProdutoForm(@PathVariable(value = "id") Integer id, Model model) {

        ProdutoEntity prod = produtoService.getProdutoId(id);

        model.addAttribute("produto", prod);

        return "atualizar-produto";
    }
    
    @GetMapping("/detalhesProduto/{id}")
public String detalhesProduto(@PathVariable("id") Integer id, Model model) {
    ProdutoEntity produto = produtoService.getProdutoId(id);
    model.addAttribute("produto", produto);
    return "detalhes-produto";
}

}

