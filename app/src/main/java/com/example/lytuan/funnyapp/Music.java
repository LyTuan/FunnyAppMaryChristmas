package com.example.lytuan.funnyapp;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

public class Music extends AppCompatActivity {
    TextView loiNhan;
    ListView lvBaiHat;
    RelativeLayout mh;
    MediaPlayer song;
    ArrayList<String> mangTenBH,mangLoiNhan;
    ArrayList<Integer> mangMP3;

    public void AnhXa(){
        loiNhan = (TextView) findViewById(R.id.textViewLoiNhan);
        lvBaiHat = (ListView) findViewById(R.id.listViewBaiHat);
        mh = (RelativeLayout) findViewById(R.id.manHinhMusic);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music);

        //Anh xa
        AnhXa();

        //Hinh nen
        mh.setBackgroundResource(R.drawable.bg2);


        //Play nhac nen
        song = MediaPlayer.create(getApplicationContext(),R.raw.wewishyouamerrychristmas);
        song.start();
        //Lời nhắn
        loiNhan.setText("Chúc em Giáng sinh vui vẻ!!!");
        TaoAnimation();

        //Tao mang
        TaoMang();
        ArrayAdapter adapter = new ArrayAdapter(getApplicationContext(),android.R.layout.simple_list_item_1,mangTenBH);
        lvBaiHat.setAdapter(adapter);
        //ListView on itemClick
        lvBaiHat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                song.stop();
                song = MediaPlayer.create(getApplicationContext(),mangMP3.get(position));
                song.start();
                loiNhan.setText(mangLoiNhan.get(position));
                //Zoom cho lời nhắn
                TaoAnimation();
            }
        });


        //back
        loiNhan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                song.stop();
                Intent mhMain = new Intent(getApplicationContext(),MainActivity.class);
                startActivity(mhMain);
            }
        });
    }
    public void TaoAnimation(){
        Animation zoom = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);
        zoom.reset();
        loiNhan.clearAnimation();
        loiNhan.startAnimation(zoom);
    }
    public  void TaoMang(){
        mangTenBH = new ArrayList<String>();
        mangLoiNhan = new ArrayList<String>();
        mangMP3 = new ArrayList<Integer>();


        mangMP3.add(R.raw.chuabaogio);
        mangTenBH.add("Chưa bao giờ");
        mangLoiNhan.add("Chưa bao giờ anh có cảm giác đó,. Anh rất vui và hạnh phúc. Ngày đêm luôn nhớ về em ngay từ cái nhìn đầu tiên");

        mangMP3.add(R.raw.lamon);
        mangTenBH.add("Làm ơn");
        mangLoiNhan.add("Anh rất sợ sợ ngày đó sẽ đến.Làm ơn đừng bỏ rơi anh nhé");

        mangMP3.add(R.raw.lamvoanhnhe);
        mangTenBH.add("Làm vợ anh nhé");
        mangLoiNhan.add("Khi nghe bài này chắc em sẽ rất vui đúng ko!!!");

        mangMP3.add(R.raw.niemkhuccuoi);
        mangTenBH.add("Niệm Khúc Cuối");
        mangLoiNhan.add("Anh nhớ mỗi lần em buồn là em lại nghe bài này!!Mọi nỗi buồn sẽ mau qua thôi vì bên em luôn có 1 người cảm thông và sẵn sàng chia sẻ em nhé");

        mangMP3.add(R.raw.songtrongnoinho);
        mangTenBH.add("Sống trong nỗi nhớ");
        mangLoiNhan.add("Đã có lúc anh mong tim mình bé lại. Để nỗi nhớ em không bao giờ thêm nữa");


    }
}
