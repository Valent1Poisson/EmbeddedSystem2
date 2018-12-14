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
import android.widget.VideoView;

import java.io.IOException;

public class TrainingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);

        // create an object of media controller
        MediaController mediaController = new MediaController(this);
        //Uri uri = Uri.parse("/ui/wp-content/uploads/2016/04/videoviewtestingvideo.mp4");

        // initiate a video view
        VideoView simpleVideoView = (VideoView) findViewById(R.id.videoView);
        simpleVideoView.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.tournicoti));
        //simpleVideoView.setVideoURI(uri);
        simpleVideoView.start();

        // set media controller object for a video view
        simpleVideoView.setMediaController(mediaController);
    }

}
