package com.example.xcode.grocery;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import com.example.xcode.grocery.GroceryData;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    private List<GroceryData> groceryData;
    private RecyclerView rv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rv = (RecyclerView) findViewById(R.id.recyclerview);

        LinearLayoutManager llm = new LinearLayoutManager(this);
        rv.setLayoutManager(llm);
        rv.setHasFixedSize(true);

        initializeData();
        initializeAdapter();
    }

    private void initializeData() {
        groceryData = new ArrayList<>();
        groceryData.add(new GroceryData("Apple", R.drawable.apple, "$CAD 10", "1 lb", "30"));
        groceryData.add(new GroceryData("Mango", R.drawable.mango, "$CAD 15", "3 lb", "40"));
        groceryData.add(new GroceryData("Banana", R.drawable.banana, "$CAD 5", "4 lb", "50"));
    }

    private void initializeAdapter() {
        RVAdapter adapter = new RVAdapter(groceryData);
        rv.setAdapter(adapter);
    }

}













