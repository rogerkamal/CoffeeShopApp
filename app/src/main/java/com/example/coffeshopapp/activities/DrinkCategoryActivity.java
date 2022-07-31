package com.example.coffeshopapp.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.coffeshopapp.R;
import com.example.coffeshopapp.model.Menu;

import java.util.ArrayList;

import com.example.coffeshopapp.adapters.MenuRecyclerViewAdapter;

public class DrinkCategoryActivity extends AppCompatActivity implements MenuRecyclerViewAdapter.OnitemViewClicklistener {

    private static final String TAG = "DrinkCate";
    private ArrayList<Menu> menulist;
    private RecyclerView MenuRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_menu);

        MenuRecyclerView = findViewById(R.id.menuRecyclerView);
        menulist = new ArrayList<>();
        setShopMenu();
        setAdapter();
    }


    private void setAdapter() {
        MenuRecyclerViewAdapter adapter = new MenuRecyclerViewAdapter(menulist, DrinkCategoryActivity.this,this);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        MenuRecyclerView.setLayoutManager(layoutManager);
        MenuRecyclerView.setItemAnimator(new DefaultItemAnimator());
        MenuRecyclerView.setAdapter(adapter);
        MenuRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }


    private void setShopMenu() {
        menulist.add(new Menu("Latte"));
        menulist.add(new Menu("Cappuchino"));
        menulist.add(new Menu("Filter Coffee"));
    }


    @Override
    public void onitemViewClick(int position) {
        Log.d(TAG, "onitemViewClick: " +position);
        if(position==0){
            Intent intent = new Intent(DrinkCategoryActivity.this,DrinkActivity.class );
            startActivity(intent);
        }
    }

}
