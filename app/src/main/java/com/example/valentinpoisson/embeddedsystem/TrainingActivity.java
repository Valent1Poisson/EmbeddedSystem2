package com.example.valentinpoisson.embeddedsystem;

import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class TrainingActivity extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        lv = (ListView) findViewById(R.id.ListVideos);

        List<String> ArrayVideo = new ArrayList<String>();
        ArrayVideo.add("Tournicoti");
        ArrayVideo.add("Half Body");

        // This is the array adapter, it takes the context of the activity as a
        // first parameter, the type of list view as a second parameter and your
        // array as a third parameter.
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                this,
                android.R.layout.simple_list_item_1,
                ArrayVideo );

        lv.setAdapter(arrayAdapter);

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position,
                                    long id) {
                Intent intent = new Intent(TrainingActivity.this, VideoActivity.class);
                String message;
                if(position==0){
                    message = "https://archive.org/download/ksnn_compilation_master_the_internet/ksnn_compilation_master_the_internet_510kb.mp4";
                }
                else if(position==1){
                    message = "https://archive.org/download/BrasilXItalia-FinalMexico1970/Wc-70FinalBrazil-italy.mp4";
                }
                else {
                    message ="https://archive.org/embed/mjbangshead/michael-jordan-bangs-head-backboard.mp4";
                }
                String url = "url";
                intent.putExtra(url, message);
                startActivity(intent);
            }
        });
    }

}
