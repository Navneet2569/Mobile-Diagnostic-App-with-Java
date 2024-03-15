package com.example.mdt;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.os.Build;
import android.os.StatFs;
import android.os.storage.StorageManager;
import android.os.Environment;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

import java.lang.reflect.Method;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageButton hardwareTest = findViewById(R.id.Button3);
        TextView deviceName=findViewById(R.id.text_devName);
        TextView IMEI1=findViewById(R.id.text_IMEI1);
        TextView IMEI2=findViewById(R.id.text_IMEI2);
        TextView version=findViewById(R.id.text_version);
        TextView cpu=findViewById(R.id.text_cpu);
        TextView ram=findViewById(R.id.text_ram);
        TextView storage=findViewById(R.id.text_storage);
        Button start=findViewById(R.id.report);

        Runtime runtime = Runtime.getRuntime();
        long totalMemory = runtime.totalMemory();
        long freeMemory = runtime.freeMemory();
        long usedMemory = totalMemory - freeMemory;

        StorageManager storageManager = (StorageManager) getSystemService(STORAGE_SERVICE);
        StatFs statFs = new StatFs(Environment.getDataDirectory().getPath());
        long blockSize = statFs.getBlockSizeLong();
        long totalBlocks = statFs.getBlockCountLong();
        long availableBlocks = statFs.getAvailableBlocksLong();
        long totalInternalStorage = totalBlocks * blockSize;
        long availableInternalStorage = availableBlocks * blockSize;

        start.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {
                    deviceName.setText("Device Name:  " + Build.DEVICE);
                    version.setText("Android Version:  " + Build.VERSION.RELEASE);
                    IMEI1.setText("IMEI1: 866559062884509");
                    IMEI2.setText("IMEI1: 866559062884510");

                    String processorInfo = "";
                    try {
                        Class<?> c = Class.forName("android.os.SystemProperties");
                        Method get = c.getMethod("get", String.class);
                        processorInfo = (String) get.invoke(c, "ro.product.cpu.abi");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    cpu.setText("CPU:  " + processorInfo);

                    DecimalFormat decimalFormat = new DecimalFormat("#.##");;
                    ram.setText("RAM:  "+decimalFormat.format((double) usedMemory / (1024 * 1024 )) + " GB/"+decimalFormat.format((double) totalMemory / (1024 * 1024 * 32)) + " GB");

                    storage.setText("Storage:  " + decimalFormat.format((double) availableInternalStorage / (1024 * 1024*1024)) + " GB/" + decimalFormat.format((double) totalInternalStorage / (1024 * 1024*1024)) + " GB");
            }
        });


        hardwareTest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HardwareTest.class);
                startActivity(intent);
            }
        });
        ImageButton systemInfo = findViewById(R.id.Button2);
        systemInfo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SystemInfo.class);
                startActivity(intent);
            }
        });
        ImageButton hardwareInfo = findViewById(R.id.Button1);
        hardwareInfo.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, HardwareInfo.class);
                startActivity(intent);
            }
        });
        ImageButton sensorTest = findViewById(R.id.Button4);
        sensorTest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SensorTest.class);
                startActivity(intent);
            }
        });
        ImageButton networkTest = findViewById(R.id.Button5);
        networkTest.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NetworkTest.class);
                startActivity(intent);
            }
        });
        ImageButton instelledAppps = findViewById(R.id.Button6);
        instelledAppps.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InstalledApps.class);
                startActivity(intent);
            }
        });
    }
}