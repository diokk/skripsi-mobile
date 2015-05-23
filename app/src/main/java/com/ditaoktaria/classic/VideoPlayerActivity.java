package com.ditaoktaria.classic;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.text.TextUtils;
import android.widget.EditText;
import android.view.MenuItem;
import android.widget.Toast;
import io.vov.vitamio.LibsChecker;
import io.vov.vitamio.MediaPlayer;
import io.vov.vitamio.widget.MediaController;
import io.vov.vitamio.widget.VideoView;


import android.view.View;


public class VideoPlayerActivity extends ActionBarActivity {

    // TODO: set path variable to a streaming video URL or a local media file path

    private String path = "http://192.168.56.1/classicdevel/video/caca.mp4";
    private VideoView mVideoView;
    private EditText mEditText;

    @Override
    protected void onCreate(Bundle icicle) {
        super.onCreate(icicle);
        if (!LibsChecker.checkVitamioLibs(this))
            return;
        setContentView(R.layout.activity_video_view);
        mVideoView = (VideoView) findViewById(R.id.surface_view);
        if (path == "") {
            // tell user to provide a media file URL/path.
            Toast.makeText(VideoPlayerActivity.this, "Please edit VideoPlayerActivity Activity, and set path", Toast.LENGTH_LONG).show();
            return;
        } else {
            mVideoView.setVideoPath(path);
            mVideoView.setMediaController(new MediaController(this));
            mVideoView.requestFocus();

            mVideoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
                @Override
                public void onPrepared(MediaPlayer mp) {
                    mp.setPlaybackSpeed(1.0f);
                }
            });

        }

    }

    public void startPlay(View view){
        String url = mEditText.getText().toString();
        path = url;
        if(!TextUtils.isEmpty(url)){
            mVideoView.setVideoPath(url);
        }
    }

    public void openVideo (View View){
        mVideoView.setVideoPath(path);
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_video_view, menu);
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
