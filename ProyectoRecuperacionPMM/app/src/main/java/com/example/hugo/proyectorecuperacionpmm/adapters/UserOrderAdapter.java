package com.example.hugo.proyectorecuperacionpmm.adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.hugo.proyectorecuperacionpmm.R;
import com.example.hugo.proyectorecuperacionpmm.model.Order;

import java.util.ArrayList;
import java.util.Locale;

public class UserOrderAdapter extends RecyclerView.Adapter<UserOrderAdapter.ViewHolder> {
    private ArrayList<Order> userOrders;

    public UserOrderAdapter(ArrayList<Order> userOrders) {
        this.userOrders = new ArrayList<>();
        this.userOrders.addAll(userOrders);
    }

    @NonNull
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.activity_user_orders, parent, false);
        return new ViewHolder(view);
    }

    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Order order = userOrders.get(position);
        holder.orderNameText.setText(R.string.order_name + " " + position + 1);
        holder.orderAddressText.setText(order.getAddress());
        holder.orderDateText.setText(order.getDate());
        holder.orderPriceText.setText(
                String.format(Locale.getDefault(), "%.2f €", order.getPrice()));
    }

    public int getItemCount() {
        return userOrders.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView orderNameText;
        TextView orderAddressText;
        TextView orderDateText;
        TextView orderPriceText;

        public ViewHolder(View itemView) {
            super(itemView);
            orderNameText = itemView.findViewById(R.id.activity_user_order_name);
            orderAddressText = itemView.findViewById(R.id.activity_user_order_address);
            orderDateText = itemView.findViewById(R.id.activity_user_order_date);
            orderPriceText = itemView.findViewById(R.id.activity_user_order_price);
        }
    }
}
