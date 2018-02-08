package com.example.hugtra.proyectobocadillo;

import java.io.Serializable;

public class Pedido implements Serializable{

    private int cantidad ;
    private String bocadillo,envio,barra;
    private float precio;

    public Pedido(float pre, String bar, int cant, String boca, String envi){

        this.barra = bar;
        this.cantidad = cant;
        this.bocadillo = boca;
        this.envio = envi;
        this.precio = pre;

    }

    public float getPrecio() {
        return precio;
    }

    public int getCantidad() {
        return cantidad;
    }


    public String getEnvio() {
        return envio;
    }

    public String getBarra() {
        return barra;
    }

    public String getBocadillo() {
        return bocadillo;
    }
}