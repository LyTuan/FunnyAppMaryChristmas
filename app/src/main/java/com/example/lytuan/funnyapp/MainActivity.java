package com.example.lytuan.funnyapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    RelativeLayout mh;
    MediaPlayer song;
    ImageView imgView;
    public  void AnhXa(){
        mh = (RelativeLayout) findViewById(R.id.manHinh);
        imgView = (ImageView) findViewById(R.id.imageView);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        //Background
        mh.setBackgroundResource(R.drawable.bg1);

        //Nhac nen
        song = MediaPlayer.create(getApplicationContext(),R.raw.wewishyouamerrychristmas);
        song.start();

        //Hieu ung hinh
        Animation f = AnimationUtils.loadAnimation(this,R.anim.fade);
        f.reset();
        imgView.clearAnimation();
        imgView.startAnimation(f);
        imgView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent mhMusic = new Intent(getApplication(),Music.class);
                startActivity(mhMusic);
                song.stop();


            }
        });
    }
}
