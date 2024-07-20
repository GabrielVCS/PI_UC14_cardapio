/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cardapio.cardapioPi.controller;

import com.cardapio.cardapioPi.model.Cliente;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@Controller // Mostra que essa classe é um controller
@RequestMapping("/clientes") // Faz todas as URLs começarem com /filmes pra esse controlador
public class ClienteHtmlController {

    private List<Cliente> clientes = new ArrayList<>(); // Lista de filmes
    private Integer currentId = 1; // Variável de teste pra gerar ids únicos aos filmes
    
    // Método para exibir a lista de filmes
    @GetMapping
    public String listarClientes(Model model, @CookieValue(value = "preferencia-tema", defaultValue = "claro") String tema) {
        model.addAttribute("tema", tema);
        return "telaInicial";
    }

    // Método para exibir o formukário de cadastro de filme
    @GetMapping("/novo")
    public String novoClienteForm(Model model) {
        model.addAttribute("cliente", new Cliente()); // Coloca um novo filme vazio no model
        return "telaCadCliente"; //Aqui mostrar o form de cadastro
    }

    // Método para processar o formulário de cadastro de filme
    @PostMapping
    public String salvarCliente(@ModelAttribute Cliente cliente) {
        cliente.setId(currentId++); // Coloca o id do filme como o próximo id disponível enquanto eu não parar de rodar
        clientes.add(cliente); // coloca o filme na lista de filmes
        return "redirect:/telaInicial"; // Redireciona para a pag de lista de filmes depois do cadastro
    }
    
    @GetMapping("/minhaConta")
    public String minhaConta() {
        return "redirect:/clientes/novo"; // Redireciona para a página de novo cliente
    }
    
    @GetMapping("/cardapio")
    public String showCardapio() {
        return "telaCardapio";
    }
    
    @GetMapping("/carrinho")
    public String showCarrinho() {
        return "telaCarrinho";
    }

    @GetMapping("/pagamento")
    public String showPagamento() {
        return "telaPagamento";
    }
}