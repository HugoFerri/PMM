package com.example.hugtra.ejemplocanvas;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(new EjemploView(this));
    }

    public class EjemploView extends View {
        public EjemploView(Context contexto) {
            super(contexto);
        }

        protected void onDraw(Canvas canvas) {
            int ancho = getWidth();
            int alto = getHeight();

            Paint pincel = new Paint();
            pincel.setColor(Color.BLUE);
            pincel.setStrokeWidth(15);
            pincel.setStyle(Paint.Style.STROKE);

            canvas.drawCircle(ancho/2, alto/2, 400, pincel);

            pincel.setColor(Color.RED);
            pincel.setStyle(Paint.Style.FILL_AND_STROKE);
            canvas.drawRect(50, 50, 200, 200, pincel);


            //Recoger imagen
            BitmapDrawable imagen;

            Resources res = this.getResources();
            imagen = (BitmapDrawable)res.getDrawable(R.drawable.css);
            imagen.setBounds(new Rect(30, 30, 200, 200));

            imagen.draw(canvas);
        }
    }
}
