package com.example.hugo.proyectorecuperacionpmm.activities;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hugo.proyectorecuperacionpmm.R;
import com.example.hugo.proyectorecuperacionpmm.data.OrderDAO;
import com.example.hugo.proyectorecuperacionpmm.data.SQLiteHelper;
import com.example.hugo.proyectorecuperacionpmm.data.UserDAO;
import com.example.hugo.proyectorecuperacionpmm.model.Order;
import com.example.hugo.proyectorecuperacionpmm.model.Sandwich;
import com.example.hugo.proyectorecuperacionpmm.model.User;

import java.util.ArrayList;
import java.util.Locale;

public class CheckoutActivity extends AppCompatActivity {
    float orderPrice;
    User user;
    EditText addressText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_checkout);

        TextView sandwichName = findViewById(R.id.activity_checkout_selectedesandwinchview);
        TextView sandwichPrice = findViewById(R.id.activity_checkout_priceview);
        Button comprar = findViewById(R.id.activity_checkout_buybutton);

        Intent intent = getIntent();

        String name = intent.getStringExtra("name");
        orderPrice = intent.getFloatExtra("price", 0);
        user = intent.getParcelableExtra("user");

        sandwichName.setText(name);
        sandwichPrice.setText(
                String.format(Locale.getDefault(), "%.2f €", orderPrice)
        );


        comprar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SQLiteHelper sqLiteHelper = SQLiteHelper.getInstance(getApplicationContext());
                UserDAO userDAO = new UserDAO(sqLiteHelper);
                OrderDAO orderDAO = new OrderDAO(sqLiteHelper);
                int userID = userDAO.getUserIDByEmail(String.format("\"%s\"", user.getEmail()));
                addressText = findViewById(R.id.activity_checkout_address);
                String address = addressText.getText().toString();
                Order order = new Order(address, orderPrice, userID);
                orderDAO.insertOrder(order);
                sqLiteHelper.close();
                Toast.makeText(getBaseContext(), "Comprado", Toast.LENGTH_LONG).show();
            }
        });
    }
}
