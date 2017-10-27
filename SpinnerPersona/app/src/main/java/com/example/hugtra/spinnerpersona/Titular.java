package com.example.hugtra.spinnerpersona;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;


public class Titular {

    private String titulo;
    private String subtitulo;
    private int imagen;

    public Titular(String tit, String sub, int img){
        titulo = tit;
        subtitulo = sub;
        imagen = img;
    }

    public String getTitulo(){  return titulo;  }
    public String getSubtitulo(){   return subtitulo;   }
    public int getImagen(){   return imagen;   }

    public void setTitulo (String titulo) {this.titulo = titulo;}
    public void setSubtitulo (String subtitulo) {this.subtitulo = subtitulo;}
    public void setImagen (int imagen) {this.imagen = imagen;}

    public String toString(){
        return(titulo + " , " + subtitulo);
    }
}