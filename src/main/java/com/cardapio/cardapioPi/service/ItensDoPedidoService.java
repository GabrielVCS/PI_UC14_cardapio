/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cardapio.cardapioPi.service;

import com.cardapio.cardapioPi.data.ItensDoPedidoEntity;
import com.cardapio.cardapioPi.data.ItensDoPedidoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItensDoPedidoService {

    @Autowired
    ItensDoPedidoRepository itensDoPedidoRepository;

    public ItensDoPedidoEntity criarItem(ItensDoPedidoEntity item) {
        return itensDoPedidoRepository.save(item);
    }

    public List<ItensDoPedidoEntity> listarTodosItens() {
        return itensDoPedidoRepository.findAll();
    }
}
