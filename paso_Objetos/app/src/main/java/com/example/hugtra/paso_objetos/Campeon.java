package com.example.hugtra.paso_objetos;

import java.io.Serializable;

/**
 * Created by hugtra on 28/11/17.
 */

public class Campeon implements Serializable{
    private String nombre;
    private String tipo;
    private int precio;
    private int foto;

    public Campeon(String name,String type,int price,int picture){
        nombre=name;
        tipo=type;
        precio=price;
        foto=picture;
    }

    public int getFoto() {
        return foto;
    }

    public String getNombre() {
        return nombre;
    }

    public int getPrecio() {
        return precio;
    }

    public String getTipo() {
        return tipo;
    }
}
