package com.example.coffeshopapp.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

import com.example.coffeshopapp.R;
import com.example.coffeshopapp.model.Menu;

import java.util.ArrayList;

import com.example.coffeshopapp.adapters.MenuRecyclerViewAdapter;

public class MainActivity extends AppCompatActivity implements MenuRecyclerViewAdapter.OnitemViewClicklistener {
    private static final String TAG = "Clicked";
    private ArrayList<Menu> menulist;
    private RecyclerView MenuRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MenuRecyclerView = findViewById(R.id.menuRecyclerView);
        menulist = new ArrayList<>();
        setShopMenu();
        setAdapter();
        }

    private void setAdapter() {
    MenuRecyclerViewAdapter adapter = new MenuRecyclerViewAdapter(menulist, MainActivity.this,this);
    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
    MenuRecyclerView.setLayoutManager(layoutManager);
    MenuRecyclerView.setItemAnimator(new DefaultItemAnimator());
    MenuRecyclerView.setAdapter(adapter);
    MenuRecyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
    }


    private void setShopMenu() {
        menulist.add(new Menu("Drinks"));
        menulist.add(new Menu("Food"));
        menulist.add(new Menu("Others"));
    }


    @Override
    public void onitemViewClick(int position) {
        Log.d(TAG, "onitemViewClick: " +position);
           if(position==0){
                    Intent intent = new Intent(MainActivity.this,DrinkCategoryActivity.class );
                    startActivity(intent);
                }
    }
};
