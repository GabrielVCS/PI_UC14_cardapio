/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cardapio.cardapioPi.service;

import com.cardapio.cardapioPi.data.PedidoEntity;
import com.cardapio.cardapioPi.data.PedidoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    PedidoRepository pedidoRepository;

    public PedidoEntity criarPedido(PedidoEntity pedido) {
        pedido.setId(null);
        return pedidoRepository.save(pedido);
    }

    public PedidoEntity atualizarPedido(Integer pedidoId, PedidoEntity pedidoRequest) {
        PedidoEntity pedido = getPedidoById(pedidoId);
        pedido.setCliente(pedidoRequest.getCliente());
        pedido.setValorTotal(pedidoRequest.getValorTotal());
        pedido.setPago(pedidoRequest.isPago());
        return pedidoRepository.save(pedido);
    }

    public PedidoEntity getPedidoById(Integer pedidoId) {
        return pedidoRepository.findById(pedidoId).orElse(null);
    }

    public List<PedidoEntity> listarTodosPedidos() {
        return pedidoRepository.findAll();
    }

    public void deletarPedido(Integer pedidoId) {
        pedidoRepository.deleteById(pedidoId);
    }
}
