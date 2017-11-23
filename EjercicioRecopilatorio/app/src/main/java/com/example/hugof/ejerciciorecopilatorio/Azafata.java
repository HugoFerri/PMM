package com.example.hugof.ejerciciorecopilatorio;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Azafata extends AppCompatActivity {



    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EjemploView(this));
    }

    public class EjemploView extends View {
        public EjemploView(Context contexto) {
            super(contexto);
            Resources res = contexto.getResources();

        }

        @Override
        protected void onDraw(Canvas canvas) {

            Paint pincel = new Paint();
            pincel.setColor(Color.BLACK);
            pincel.setStrokeWidth(15);
            pincel.setStyle(Paint.Style.STROKE);
            canvas.drawLine(500,50,350,350,pincel);
            canvas.drawLine(500,50,700,350,pincel);
            canvas.drawLine(350,350,700,350,pincel);
            pincel.setColor(Color.BLACK);
            canvas.drawCircle(520, 500, 150, pincel);
            pincel.setColor(Color.BLUE);
            canvas.drawCircle(450,480,20,pincel);
            canvas.drawCircle(580,480,20,pincel);
            canvas.drawLine(450,600,580,600,pincel);
            pincel.setColor(Color.BLACK);
            canvas.drawLine(430,660,380,1050,pincel);
            canvas.drawLine(600,660,650,1050,pincel);
            canvas.drawLine(430,660,600,660,pincel);
            canvas.drawLine(380,1050,650,1050,pincel);
            canvas.drawLine(430,700,250,900,pincel);
            canvas.drawLine(610,700,790,900,pincel);
            canvas.drawLine(550,1050,550,1300,pincel);
            canvas.drawLine(500,1050,500,1300,pincel);
            pincel.setStrokeWidth(5);
            pincel.setTextSize(40);
            pincel.setColor(Color.BLACK);
            canvas.drawText("Drawed by Hugo Ferri Tramoyeres",200,1400,pincel);

        }
    }
}
