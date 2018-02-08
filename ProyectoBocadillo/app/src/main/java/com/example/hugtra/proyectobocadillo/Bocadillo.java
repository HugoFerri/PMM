package com.example.hugtra.proyectobocadillo;

import java.io.Serializable;

public class Bocadillo implements Serializable {
    private String nombre;
    private float precio;
    private String ingredientes;
    int ids;

    public Bocadillo(String nom, float pre, String ingr, int id) {
        nombre = nom;
        precio = pre;
        ingredientes = ingr;
        ids = id;
    }

    public String getIngredientes() {
        return ingredientes;
    }

    public float getPrecio() {
        return precio;
    }

    public String getNombre() {
        return nombre;
    }

    public int getId() {
        return ids;
    }
}
