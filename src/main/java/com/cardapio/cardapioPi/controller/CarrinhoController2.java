/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cardapio.cardapioPi.controller;

import com.cardapio.cardapioPi.data.ItensDoPedidoEntity;
import com.cardapio.cardapioPi.data.PedidoEntity;
import com.cardapio.cardapioPi.service.ItensDoPedidoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/carrinho2")
public class CarrinhoController2 {

    @Autowired
    private ItensDoPedidoService itensDoPedidoService;

    @GetMapping("/itens")
    public List<ItensDoPedidoEntity> listarItensDoCarrinho(HttpSession session) {
        PedidoEntity pedido = (PedidoEntity) session.getAttribute("pedido");
        if (pedido != null) {
            return itensDoPedidoService.listarTodosItens(); // Filtrar itens por pedido só se preciasar
        }
        return List.of();
    }
}
