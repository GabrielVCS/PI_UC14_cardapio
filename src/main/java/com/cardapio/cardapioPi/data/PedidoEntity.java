/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cardapio.cardapioPi.data;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "Pedido")
public class PedidoEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "ID_cliente")
    private ClienteEntity cliente;

    private double valorTotal;
    private boolean pago;
}
