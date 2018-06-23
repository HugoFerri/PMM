package com.example.hugo.proyectorecuperacionpmm.activities;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hugo.proyectorecuperacionpmm.R;
import com.example.hugo.proyectorecuperacionpmm.model.Sandwich;
import com.example.hugo.proyectorecuperacionpmm.model.User;

import java.util.Locale;

public class DetailsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ImageView sandwichPhoto = findViewById(R.id.activity_sandwich_details_photo);
        TextView sandwichName = findViewById(R.id.activity_sandwich_details_name);
        TextView sandwichIngredients = findViewById(R.id.activity_sandwich_details_ingredients);
        TextView sandwichPrice = findViewById(R.id.activity_sandwich_details_price);
        Button addSandwichButton = findViewById(R.id.activity_sandwich_details_buy);

        final Sandwich sandwich = getIntent().getParcelableExtra("sandwich");

        sandwichPhoto.setImageResource(sandwich.getPhotoId());
        sandwichName.setText(sandwich.getName());
        sandwichIngredients.setText(sandwich.getIngredients());
        sandwichPrice.setText(
                String.format(Locale.getDefault(), "%.2f €", sandwich.getPrice())
        );

        final User user = getIntent().getParcelableExtra("user");

        addSandwichButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = sandwich.getName();
                float price = sandwich.getPrice();

                Intent intent = new Intent(DetailsActivity.this, CheckoutActivity.class);
                intent.putExtra("name", name);
                intent.putExtra("price", price);
                intent.putExtra("user", user);
                startActivity(intent);
            }
        });
    }
}
