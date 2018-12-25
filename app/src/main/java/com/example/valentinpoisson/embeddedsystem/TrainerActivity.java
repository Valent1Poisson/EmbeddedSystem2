package com.example.valentinpoisson.embeddedsystem;

import android.content.ClipData;
import android.content.Context;
import android.content.Intent;
import android.service.carrier.CarrierService;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import static java.security.AccessController.getContext;

public class TrainerActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private List<MyObject> coachs = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer);

        //remplir la ville
        ajouterCoachs();

        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);

        //définit l'agencement des cellules, ici de façon verticale, comme une ListView
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //pour adapter en grille comme une RecyclerView, avec 2 cellules par ligne
        //recyclerView.setLayoutManager(new GridLayoutManager(this,2));

        //puis créer un MyAdapter, lui fournir notre liste de villes.
        //cet adapter servira à remplir notre recyclerview
        recyclerView.setAdapter(new MyAdapter(coachs));

        recyclerView.addOnItemTouchListener(new RecyclerTouchListener(this,
                recyclerView, new ClickListener() {
            @Override
            public void onClick(View view, final int position) {
                //Values are passing to activity & to fragment as well
                Intent intent = new Intent(TrainerActivity.this, CardActivity.class);
                MyObject messageInfo = coachs.get(position);
                String Name = messageInfo.getText();
                String id = "id";
                intent.putExtra(id,Name);
                startActivity(intent);
            }

            @Override
            public void onLongClick(View view, int position) {
                //
            }
        }));

    }

    private void ajouterCoachs() {
        coachs.add(new MyObject("Toto","http://cdn.journaldev.com/wp-content/uploads/2016/11/android-image-picker-project-structure.png"));
        coachs.add(new MyObject("Lili","http://cdn.journaldev.com/wp-content/uploads/2016/11/android-image-picker-project-structure.png"));
        coachs.add(new MyObject("Jasmine","http://cdn.journaldev.com/wp-content/uploads/2016/11/android-image-picker-project-structure.png"));
        coachs.add(new MyObject("Paulo","http://cdn.journaldev.com/wp-content/uploads/2016/11/android-image-picker-project-structure.png"));
    }

}