package com.ditaoktaria.classic;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.net.Uri;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.VideoView;
import android.view.SurfaceView;
import android.view.SurfaceHolder;
import android.media.MediaPlayer.OnPreparedListener;
import android.media.MediaPlayer;
import android.media.AudioManager;
import android.util.Log;

public class videoplayer extends ActionBarActivity {

    String TAG = "com.example.VideoPlayer";
    protected void onStart(){
        super.onStart();

        final VideoView videoView =
                (VideoView) findViewById(R.id.myVideo);

        videoView.setVideoPath(
                "http://192.168.56.1/classicdevel/video/rtcweb.mp4");

        MediaController mediaController = new
                MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener()  {
            @Override
            public void onPrepared(MediaPlayer mp) {
                Log.i(TAG, "Duration = " + videoView.getDuration());
            }
        });

        videoView.start();

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_videoplayer);
/*
        VideoView vidView = (VideoView)findViewById(R.id.myVideo);


        String vidAddress = "http://192.168.56.1/classicdevel/video/jaranan.mp4";
        Uri vidUri = Uri.parse(vidAddress);
        vidView.setVideoURI(vidUri);

        MediaController vidControl = new MediaController(this);
        vidControl.setAnchorView(vidView);
        vidView.setMediaController(vidControl);
        vidView.start();*/




    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_videoplayer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
