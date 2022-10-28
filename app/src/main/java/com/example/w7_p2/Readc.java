package com.example.w7_p2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import android.os.Bundle;

public class Readc extends AppCompatActivity {
    private ArrayList<Model> modarr;
    private DB db;
    private Adapters adapters;
    private RecyclerView rec;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_readc);
        modarr = new ArrayList<>();
        db = new DB(Readc.this);
        modarr = db.showList();
        adapters = new Adapters(modarr, Readc.this);
        rec = findViewById(R.id.Rd);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(Readc.this, RecyclerView.VERTICAL, false);
        rec.setLayoutManager(linearLayoutManager);
        rec.setAdapter(adapters);

    }


    }