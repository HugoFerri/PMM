package com.example.hugtra.menu;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import static com.example.hugtra.menu.R.id.MnuOpc2;

public class MainActivity extends AppCompatActivity {
    TextView lblMensaje = (TextView) findViewById(R.id.lblMensaje);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        registerForContextMenu(lblMensaje);
    }

    //I)nflater menu
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_principal, menu);
        return true;
    }

    //Inflater menu contextual
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.context_menu, menu);
    }

    public boolean onOptionsItemSelected(MenuItem item) {
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
            case R.id.CtxLblOpc1:
                lblMensaje.setText("Etiqueta: Opcion 1 pulsada!");
                return true;
            case R.id.CtxLblOpc2:
                lblMensaje.setText("Etiqueta: Opcion 2 pulsada!");
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }
}
