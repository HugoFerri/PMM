package com.example.hugo.proyectorecuperacionpmm.activities;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import com.example.hugo.proyectorecuperacionpmm.R;
import com.example.hugo.proyectorecuperacionpmm.adapters.UserOrderAdapter;
import com.example.hugo.proyectorecuperacionpmm.data.OrderDAO;
import com.example.hugo.proyectorecuperacionpmm.data.SQLiteHelper;
import com.example.hugo.proyectorecuperacionpmm.data.UserDAO;
import com.example.hugo.proyectorecuperacionpmm.model.Order;
import com.example.hugo.proyectorecuperacionpmm.model.User;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class ProfileActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        final User user = getIntent().getParcelableExtra("user");

        TextView nameText = findViewById(R.id.fragment_profile_name);
        RecyclerView recyclerView = findViewById(R.id.fragment_profile_recycler);

        SQLiteHelper sqLiteHelper = SQLiteHelper.getInstance(getApplicationContext());
        UserDAO userDAO = new UserDAO(sqLiteHelper);
        OrderDAO orderDAO = new OrderDAO(sqLiteHelper);

        ArrayList<Order> userOrders = new ArrayList<>();
        String userEmail = user.getEmail();

        int userID = userDAO.getUserIDByEmail(String.format("\"%s\"", userEmail));
        Cursor cursor = orderDAO.getOrderByUserID(userID);
        if (cursor.moveToFirst()) {
            while (cursor.moveToNext()) {
                userOrders.add(new Order(cursor));
            }
        }
        sqLiteHelper.close();
        cursor.close();

        UserOrderAdapter userOrderAdapter = new UserOrderAdapter(userOrders);

        nameText.setText(userEmail);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(userOrderAdapter);
    }
}
