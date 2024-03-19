package com.example.mdt;

import android.annotation.SuppressLint;
import android.bluetooth.BluetoothAdapter;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;

import androidx.appcompat.app.AppCompatActivity;

public class Bluetooth extends AppCompatActivity {
    ToggleButton tblbutton;
    BluetoothAdapter mBluetoothAdapter;
    TextView out;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bluetooth);
        tblbutton = findViewById(R.id.toggleButton);

        // Check if Bluetooth is supported on the device
        if (BluetoothAdapter.getDefaultAdapter() == null) {
            tblbutton.setEnabled(false); // Disable the ToggleButton
            Toast.makeText(getApplicationContext(), "Bluetooth not supported", Toast.LENGTH_LONG).show();
        } else {
            // Bluetooth is supported, initialize BluetoothAdapter
            mBluetoothAdapter = BluetoothAdapter.getDefaultAdapter();
            out = findViewById(R.id.textView6);

            tblbutton.setOnClickListener(new View.OnClickListener() {
                @SuppressLint("MissingPermission")
                @Override
                public void onClick(View view) {
                    if (tblbutton.isChecked()) {
                        mBluetoothAdapter.enable();
                        Toast.makeText(getApplicationContext(), "Bluetooth turned ON", Toast.LENGTH_LONG).show();
                        out.setText("Name: " + mBluetoothAdapter.getName());
                        out.append("\nAddress: " + mBluetoothAdapter.getAddress());
                        out.append("\nBonded Devices: " + mBluetoothAdapter.getBondedDevices());
                    } else {
                        mBluetoothAdapter.disable();
                        Toast.makeText(getApplicationContext(), "Bluetooth turned OFF", Toast.LENGTH_LONG).show();
                        out.setText("");
                    }
                }
            });
        }
    }
}
