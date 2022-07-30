package com.example.coffeshopapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeshopapp.R;
import com.example.coffeshopapp.model.Menu;

import java.util.ArrayList;


public class MenuRecyclerViewAdapter extends RecyclerView.Adapter<MenuRecyclerViewAdapter.ViewHolder> {
    private OnitemViewClicklistener onitemViewClicklistener;
    private final ArrayList<Menu> menulist;
    private final Context context;

    public MenuRecyclerViewAdapter(ArrayList<Menu> menulist,Context context, OnitemViewClicklistener onitemViewClicklistener){
        this.menulist = menulist;
        this.context = context;
        this.onitemViewClicklistener = onitemViewClicklistener;
    }


    @NonNull
    @Override
    public MenuRecyclerViewAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View itemview= layoutInflater.inflate(R.layout.custom_row_layout, parent, false);
        return  new ViewHolder(itemview, onitemViewClicklistener);
    }


    @Override
    public void onBindViewHolder(@NonNull MenuRecyclerViewAdapter.ViewHolder holder, int position) {
            String drinkName = menulist.get(position).getMenuItem();
            holder.MenuText.setText(drinkName);
    }

    @Override
    public int getItemCount() {
        return menulist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        OnitemViewClicklistener onitemViewClicklistener;
        private TextView MenuText;


        public ViewHolder(final View itemView, OnitemViewClicklistener onitemViewClicklistener) {
            super(itemView);
            MenuText = itemView.findViewById(R.id.menu_name);
            this.onitemViewClicklistener = onitemViewClicklistener;

            itemView.setOnClickListener(this);
        }


        @Override
        public void onClick(View view) {
            onitemViewClicklistener.onitemViewClick(getAdapterPosition());
        }
    }

    public interface OnitemViewClicklistener{
        void onitemViewClick(int position);
    }

}

