package com.example.chatapp2;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.startapp.sdk.adsbase.Ad;
import com.startapp.sdk.adsbase.StartAppAd;
import com.startapp.sdk.adsbase.adlisteners.AdEventListener;
import com.startapp.sdk.adsbase.adlisteners.VideoListener;

public class MainActivity extends AppCompatActivity {

    private Button button, button2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.ads1);
        button2 = findViewById(R.id.ads2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                startActivity(new Intent(MainActivity.this,adsActivity.class));
                StartAppAd.showAd(MainActivity.this);


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,adsActivity.class));

                showRewardvideo();
            }
        });

        StartAppAd.showAd(this);
    }

    private void showRewardvideo() {
        final StartAppAd rewaredVideo = new StartAppAd(this);
        rewaredVideo.setVideoListener(new VideoListener() {
            @Override
            public void onVideoCompleted() {

            }
        });

        rewaredVideo.loadAd(StartAppAd.AdMode.REWARDED_VIDEO, new AdEventListener() {
            @Override
            public void onReceiveAd(@NonNull Ad ad) {

                rewaredVideo.showAd();
            }

            @Override
            public void onFailedToReceiveAd(@Nullable Ad ad) {

            }
        });

    }
}