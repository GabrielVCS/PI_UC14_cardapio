/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cardapio.cardapioPi.controller;

import com.cardapio.cardapioPi.data.ItensDoPedidoEntity;
import com.cardapio.cardapioPi.data.PedidoEntity;
import com.cardapio.cardapioPi.model.ItemCarrinho;
import com.cardapio.cardapioPi.service.ItensDoPedidoService;
import com.cardapio.cardapioPi.service.PedidoService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/carrinho")
public class CarrinhoController {

    @Autowired
    private ItensDoPedidoService itensDoPedidoService;

    @Autowired
    private PedidoService pedidoService;

    @PostMapping("/adicionar")
    public ItensDoPedidoEntity adicionarAoCarrinho(@RequestBody ItemCarrinho itemCarrinho, HttpSession session) {
        PedidoEntity pedido = (PedidoEntity) session.getAttribute("pedido");
        if (pedido == null) {
            pedido = new PedidoEntity();
            pedido.setValorTotal(0);
            pedido.setPago(false);
            pedido = pedidoService.criarPedido(pedido);
            session.setAttribute("pedido", pedido);
        }

        ItensDoPedidoEntity item = new ItensDoPedidoEntity();
        item.setItemPedido(itemCarrinho.getName());
        item.setValorTotal(itemCarrinho.getPrice());
        item.setQuantidade(itemCarrinho.getQuantity());
        item.setPedido(pedido);

        return itensDoPedidoService.criarItem(item);
    }
}

