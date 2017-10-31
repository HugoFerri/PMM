package com.example.hugtra.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static com.example.hugtra.menu.R.id.MnuOpc2;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public boolean onCreateOptionsMenu(Menu menu) {
        //Alternativa 1
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        TextView lblMensaje = (TextView) findViewById(R.id.lblMensaje);
        switch (item.getItemId()) {
            case R.id.MnuOpc1:
                lblMensaje.setText("Opcion 1 pulsada!");
                return true;
            case MnuOpc2:
                Intent miIntent = new Intent(MainActivity.this, AcercaDe.class);
                startActivity(miIntent);
                return true;
            case R.id.MnuOpc3:
                lblMensaje.setText("Opcion 3 pulsada!");;
                return true;
            case R.id.SubMnuOpc1:
                lblMensaje.setText("Opcion 3.1 pulsada!");;
                return true;
            case R.id.SubMnuOpc2:
                lblMensaje.setText("Opcion 3.2 pulsada!");;
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }}

}
