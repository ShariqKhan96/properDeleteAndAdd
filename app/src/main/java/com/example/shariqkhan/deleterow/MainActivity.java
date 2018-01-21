package com.example.shariqkhan.deleterow;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<model> arrayList = new ArrayList<>();
    RecyclerView recview;
    RecyclerView.Adapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recview = (RecyclerView) findViewById(R.id.recyclerView);
        recview.setLayoutManager(new LinearLayoutManager(this));
        adapter = new recAdapter(arrayList, this);
        recview.setAdapter(adapter);
        initArrayList();



    }

    private void initArrayList() {
        for (int i = 0; i < 10; i++) {
            model m = new model();
            m.setEmail("kshariq80@yahoo.com" + String.valueOf(i+1));
            m.setId(String.valueOf(i + 1));
            m.setName("shariq");
            arrayList.add(m);

        }
        adapter.notifyDataSetChanged();
    }
}
