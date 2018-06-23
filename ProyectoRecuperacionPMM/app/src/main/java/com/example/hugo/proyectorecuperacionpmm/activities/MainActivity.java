package com.example.hugo.proyectorecuperacionpmm.activities;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.example.hugo.proyectorecuperacionpmm.R;
import com.example.hugo.proyectorecuperacionpmm.adapters.SandwichListAdapter;
import com.example.hugo.proyectorecuperacionpmm.data.SQLiteHelper;
import com.example.hugo.proyectorecuperacionpmm.data.SandwichDAO;
import com.example.hugo.proyectorecuperacionpmm.model.Sandwich;
import com.example.hugo.proyectorecuperacionpmm.model.User;

import java.sql.Array;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements
        SandwichListAdapter.ItemClickListener {
    private SandwichListAdapter sandwichListAdapter;
    private User user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView = findViewById(R.id.activity_sandwich_list_recycler);

        // Insertamos los datos de prueba en la base da datos
        SQLiteHelper sqLiteHelper = SQLiteHelper.getInstance(this);
        SandwichDAO sandwichDAO = new SandwichDAO(sqLiteHelper);
        sandwichDAO.insertMockData();

        user = getIntent().getParcelableExtra("user");

        // Consulta a la base de datos de los bocadillos
        Cursor cursor = sandwichDAO.getAllSandwiches();

        // Obtenemos un array con todos los bocadillos
        ArrayList sandwiches = new ArrayList<>();
        while (cursor.moveToNext()) {
            sandwiches.add(new Sandwich(cursor));
        }

        // Cerramos el cursor y la base de datos
        sqLiteHelper.close();
        cursor.close();

        sandwichListAdapter = new SandwichListAdapter(sandwiches);
        sandwichListAdapter.setItemClickListener(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(sandwichListAdapter);
    }

    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.About:
                Intent acercade = new Intent(MainActivity.this, AboutActivity.class);
                startActivity(acercade);
                return true;
            case R.id.Profile:
                Intent miperfil = new Intent(MainActivity.this, ProfileActivity.class);
                miperfil.putExtra("user", user);
                startActivity(miperfil);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    /**
     *  Sobreescribe el evento onClick() de SandwichListAdapter.
     */
    @Override
    public void onItemClick(View view, final int position) {
        Sandwich sandwich = sandwichListAdapter.getSandwich(position);

        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("sandwich", sandwich);
        intent.putExtra("user", user);
        startActivity(intent);
    }
}
