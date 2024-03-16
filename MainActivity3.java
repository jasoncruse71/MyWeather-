package com.example.myweathernew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity3 extends AppCompatActivity {

    private RecyclerView.Adapter adapterTomorrow;
    public RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        initRecyclerView();
        setVariable();
        setVariable1();
    }

    private void setVariable() {
        ConstraintLayout backBtn = findViewById(R.id.backBtn);
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity3.this,MainActivity2.class));
            }
        });
    }

    private void setVariable1() {
        ImageView image = findViewById(R.id.imageOnClick);

        image.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity3.this, MainActivity4.class));
            }
        });
    }

    private void initRecyclerView() {
        ArrayList<Domain> items = new ArrayList<>();

        items.add(new Domain("Sat", "@drawable/stormy", "Storm",25,10));
        items.add(new Domain("Sun", "@drawable/cloudy", "Cloudy",24,16));
        items.add(new Domain("Mon", "@drawable/windy1", "Windy",29,15));
        items.add(new Domain("Tue", "@drawable/cloudy", "Cloudy",22,13));
        items.add(new Domain("Wed", "@drawable/sunny", "Sunny",20,11));
        items.add(new Domain("Thur", "@drawable/rainy", "Rainy",23,12));

        recyclerView = findViewById(R.id.view2);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL,false));

        adapterTomorrow = new FutureAdapters(items);
        recyclerView.setAdapter(adapterTomorrow);
    }
}