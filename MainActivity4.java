package com.example.myweathernew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    private  RecyclerView.Adapter recyclerViewAdapter;

    public RecyclerView recyclerView;

    public TextView weatherAlert;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        initRecyclerView();

        weatherAlert = findViewById(R.id.textView14);

        weatherAlert.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity4.this, MainActivity5.class));
            }
        });
    }


    private void initRecyclerView() {
        ArrayList<CountryDomain> items = new ArrayList<>();

        items.add(new CountryDomain("@drawable/stormy","New York",25,10));
        items.add(new CountryDomain("@drawable/windy1","Philippines",24,11));
        items.add(new CountryDomain("@drawable/rainy","London",22,8));
        items.add(new CountryDomain("@drawable/sunny","Indonesia",15,12));
        items.add(new CountryDomain("@drawable/stormy","Singapore",31,19));
        items.add(new CountryDomain("@drawable/windy1","London",21,15));
        items.add(new CountryDomain("@drawable/stormy","Canada",10,2));
        items.add(new CountryDomain("@drawable/humid","London",21,15));
        items.add(new CountryDomain("@drawable/stormy","Whistler",10,2));
        items.add(new CountryDomain("@drawable/rainy","Kamloops",10,2));
        items.add(new CountryDomain("@drawable/windy1","Colombo",10,2));

        recyclerView = findViewById(R.id.view3);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        recyclerViewAdapter = new CountryAdapter(items);
        recyclerView.setAdapter(recyclerViewAdapter);
    }
}