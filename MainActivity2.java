package com.example.myweathernew;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity2 extends AppCompatActivity {

    private RecyclerView.Adapter adapterHourly;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        initRecyclerView();
        setVariable();
    }

    private void setVariable() {
        TextView next7dayBtn = findViewById(R.id.nextBtn);
        next7dayBtn.setOnClickListener(v -> startActivity(new Intent(MainActivity2.this, MainActivity3.class)));
    }

    private void initRecyclerView() {
        ArrayList<Hourly> item = new ArrayList<>();

        item.add(new Hourly("9pm", 22, "@drawable/windy1"));
        item.add(new Hourly("11pm", 10, "@drawable/rainy"));
        item.add(new Hourly("12pm", 25, "@drawable/img_3"));
        item.add(new Hourly("1am", 15, "@drawable/rainy"));
        item.add(new Hourly("2am", 22, "@drawable/windy1"));

        recyclerView = findViewById(R.id.view1);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL,false));

        adapterHourly = new HourlyAdapters(item);
        recyclerView.setAdapter(adapterHourly);
    }
}