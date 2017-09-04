package com.example.yonny.semana3;

        import android.app.Activity;
        import android.content.Intent;
        import android.net.Uri;
        import android.os.Bundle;
        import android.view.Menu;
        import android.view.View;
        import android.widget.MediaController;
        import android.widget.VideoView;


public class MainActivity extends Activity {
    private VideoView videoView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        videoView = (VideoView)findViewById(R.id.videoview);
        videoView.setMediaController(new MediaController(this));
//        videoView.setVideoURI(Uri.parse("http://clips.vorwaerts-gmbh.de/big_buck_bunny.mp4"));[Es posible usar un video via streaming. ]
        videoView.setVideoURI(Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.pizza));
        videoView.start();



    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    public void siguiente(View view){
        Intent i=new Intent(this,Main2Activity.class);
        startActivity(i);
    }
}