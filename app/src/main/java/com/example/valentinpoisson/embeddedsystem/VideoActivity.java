package com.example.valentinpoisson.embeddedsystem;

import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import java.io.IOException;

public class VideoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_video);
        try {
            // create an object of media controller
            MediaController mediaController = new MediaController(this);

            // initiate a video view
            VideoView simpleVideoView = (VideoView) findViewById(R.id.videoView);
            Bundle position = getIntent().getExtras();
            /*
            if (position.getInt("url") == 0) {
                simpleVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.tournicoti));
                simpleVideoView.start();
            }
            */
            String URL = position.getString("url");
            Uri uri = Uri.parse(URL);
            simpleVideoView.setVideoURI(uri);
            simpleVideoView.start();

            // set media controller object for a video view
            simpleVideoView.setMediaController(mediaController);
        }
        catch (Exception e) {
            Toast.makeText(this,e.getMessage(),Toast.LENGTH_LONG).show();
            System.out.println("Video Play Error :" + e.getMessage());
        }
    }

}