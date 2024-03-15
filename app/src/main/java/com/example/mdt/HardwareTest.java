package com.example.mdt;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HardwareTest extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_hardware);
        CardView gps = findViewById(R.id.card_GPS);
        gps.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(HardwareTest.this, GPS.class);
                startActivity(intent);
            }
        });

        CardView camera = findViewById(R.id.card_Camera);
        camera.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(HardwareTest.this, Camera.class);
                startActivity(intent);
            }
        });

        CardView bluetooth = findViewById(R.id.card_Bluetooth);
        bluetooth.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(HardwareTest.this, Bluetooth.class);
                startActivity(intent);
            }
        });

        CardView flash = findViewById(R.id.card_Flash);
        flash.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(HardwareTest.this, Flashlight.class);
                startActivity(intent);
            }
        });

        CardView vibrator = findViewById(R.id.card_Vibrator);
        vibrator.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(HardwareTest.this, Vibrator.class);
                startActivity(intent);
            }
        });

        CardView mic = findViewById(R.id.card_Microphone);
        mic.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(HardwareTest.this, Microphone.class);
                startActivity(intent);
            }
        });

        CardView speaker = findViewById(R.id.card_Speaker);
        speaker.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(HardwareTest.this, Speaker.class);
                startActivity(intent);
            }
        });


}
}
