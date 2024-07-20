/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cardapio.cardapioPi.service;

import com.cardapio.cardapioPi.data.ClienteEntity;
import com.cardapio.cardapioPi.data.ClienteRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service

public class ClienteService {

    @Autowired

    ClienteRepository clienteRepository;

    public ClienteEntity criarCliente(ClienteEntity clien) {

        clien.setId(null);

        clienteRepository.save(clien);

        return clien;

    }

    public ClienteEntity atualizarCliente(Integer clienId, ClienteEntity clienteRequest) {

        ClienteEntity clien = getClienteId(clienId);

        clien.setNome(clienteRequest.getNome());

        clien.setCpf(clienteRequest.getCpf());

        clien.setEmail(clienteRequest.getEmail());

        clien.setTelefone(clienteRequest.getTelefone());

        clienteRepository.save(clien);

        return clien;

    }

    public ClienteEntity getClienteId(Integer clienId) {

        return clienteRepository.findById(clienId).orElse(null);

    }

    public List<ClienteEntity> listarTodosClientes() {

        return clienteRepository.findAll();

    }

    public void deletarCliente(Integer clienId) {

        ClienteEntity clien = getClienteId(clienId);

        clienteRepository.deleteById(clien.getId());

    }

}