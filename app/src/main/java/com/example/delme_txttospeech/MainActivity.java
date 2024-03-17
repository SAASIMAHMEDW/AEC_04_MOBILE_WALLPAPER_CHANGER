package com.example.delme_txttospeech;

import android.annotation.SuppressLint;
import android.app.WallpaperManager;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import java.io.IOException;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Button startbtn;
    Drawable drawable;
    Timer timer;
    WallpaperManager wallpaperManager;
    int prev = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startbtn = findViewById(R.id.startbtn);
        timer = new Timer();
        wallpaperManager = WallpaperManager.getInstance(this);
        startbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setWallpaper();
            }
        });
    }
    public  void  setWallpaper(){
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                if(prev==1){
                    drawable =  getResources().getDrawable(R.drawable.cat);
                    prev = 2;
                } else if (prev==2) {
                    drawable =  getResources().getDrawable(R.drawable.dog);
                    prev = 1;
                }
                Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
                try {
                    wallpaperManager.setBitmap(bitmap);
                }catch (IOException ioException){
                    ioException.printStackTrace();
                }
            }
        },0,5000);
//        timer.schedule(new TimerTask() {
////            @SuppressLint("UseCompatLoadingForDrawables")
//            @Override
//            public void run() {
//                if(prev==1){
//                    drawable =  getResources().getDrawable(R.drawable.cat);
//                    prev = 2;
//                } else if (prev==2) {
//                    drawable =  getResources().getDrawable(R.drawable.dog);
//                    prev = 1;
//                }
//                Bitmap bitmap = ((BitmapDrawable)drawable).getBitmap();
//                try {
//                    wallpaperManager.setBitmap(bitmap);
//                }catch (IOException ioException){
//                    ioException.printStackTrace();
//                }
//            }
//        },0,10000);
    }

}