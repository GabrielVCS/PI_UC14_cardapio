/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cardapio.cardapioPi.controller;

import com.cardapio.cardapioPi.data.ClienteEntity;
import com.cardapio.cardapioPi.service.ClienteService;
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

public class CliiController {

    @Autowired
    ClienteService clienteService;

    @GetMapping("/")
    public String viewHomePage(Model model) {
        model.addAttribute("listarClientes", clienteService.listarTodosClientes());
        return "telaInicial";
    }

    @GetMapping("/deletarCliente/{id}")
    public String deletarCliente(@PathVariable(value = "id") Integer id) {
        clienteService.deletarCliente(id);
        return "redirect:/";
    }

    @GetMapping("/criarClienteForm")
    public String criarClienteForm(Model model) {
        ClienteEntity clii = new ClienteEntity();
        model.addAttribute("cliente", clii);
        return "telaCadCliente";
    }

    @PostMapping("/salvarCliente")

    public String salvarCliente(@Valid @ModelAttribute("cliente") ClienteEntity clii, BindingResult result) {

        if (result.hasErrors()) {

            return "telaCadCliente";

        }

        if (clii.getId() == null) {

            clienteService.criarCliente(clii);

        } else {

            clienteService.atualizarCliente(clii.getId(), clii);

        }

        return "redirect:/";

    }

    @GetMapping("/atualizarClienteForm/{id}")

    public String atualizarClienteForm(@PathVariable(value = "id") Integer id, Model model) {

        ClienteEntity clii = clienteService.getClienteId(id);

        model.addAttribute("cliente", clii);

        return "atualizar-cliente";
    }
    
    @GetMapping("/detalhesCliente/{id}")
public String detalhesCliente(@PathVariable("id") Integer id, Model model) {
    ClienteEntity cliente = clienteService.getClienteId(id);
    model.addAttribute("cliente", cliente);
    return "detalhes-cliente";
}

}

