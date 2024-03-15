package com.example.mdt;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class HardwareInfo extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hardware_info);
        CardView battery = findViewById(R.id.card_battery);
        battery.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(HardwareInfo.this, Battery.class);
                startActivity(intent);
            }
        });
        CardView processor = findViewById(R.id.card_cpu);
        processor.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(HardwareInfo.this, CPU.class);
                startActivity(intent);
            }
        });
        CardView memory = findViewById(R.id.card_storage);
        memory.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                Intent intent = new Intent(HardwareInfo.this, Memory.class);
                startActivity(intent);
            }
        });
    }
}