/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cardapio.cardapioPi.data;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ItensDoPedido")
public class ItensDoPedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String itemPedido;

    @ManyToOne
    @JoinColumn(name = "produtoID")
    private ProdutoEntity produto;

    private double valorTotal;
    private int quantidade;

    @ManyToOne
    @JoinColumn(name = "id_pedido")
    private PedidoEntity pedido;
}
