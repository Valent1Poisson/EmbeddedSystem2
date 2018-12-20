package com.example.valentinpoisson.embeddedsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class TrainerActivity extends AppCompatActivity {

    private ListView lc;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer);

        lc = (ListView) findViewById(R.id.ListCoach);

        List<String> ArrayVideo = new ArrayList<String>();
        ArrayVideo.add("Pierre");
        ArrayVideo.add("Paul");

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                ArrayVideo );

        lc.setAdapter(arrayAdapter);

        lc.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(TrainerActivity.this, CardActivity.class);
                int message = position;
                String nbr = "nbr";
                intent.putExtra(nbr, message);
                startActivity(intent);
            }
        });

    }

}